package com.hzihui.virgo.netty.config;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.hzihui.virgo.netty.handle.UserChannelBind;
import com.hzihui.virgo.netty.packets.ChatBody;
import com.hzihui.virgo.netty.strategy.BaseProcessor;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

/**
 * 处理消息的handler
 * @author HZIHUI
 * @since 2019/11/20
 *
 */
@Slf4j
public class MessageHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

	/**
	 * 用于记录和管理所有客户端的channle
	 */
	public static ChannelGroup users = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

	/**
	 * 读取客户端消息通道
	 * @param ctx 当前与客户端的通道
	 * @param msg 在netty中，是用于为websocket专门处理文本的对象，frame是消息的载体
	 */
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) {
		// 获取客户端传输过来的消息
		String content = msg.text();
		ChatBody chatBody = JSONUtil.toBean(content, ChatBody.class);
		//当前通道
		Channel channel = ctx.channel();
		//处理消息
		BaseProcessor.handleReceiveMessage(chatBody,channel);
	}
	
	/**
	 * 当客户端连接服务端之后（打开连接）
	 * 获取客户端的channle，并且放到ChannelGroup中去进行管理
	 */
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) {
		users.add(ctx.channel());
		log.debug("客户端连接成功,channelId为：{}",ctx.channel().id());
	}

	/**
	 * 移除客户端通道，
	 * 当触发handlerRemoved，ChannelGroup会自动移除对应客户端的channel
	 * @param ctx
	 */
	@Override
	public void handlerRemoved(ChannelHandlerContext ctx){
		String channelId = ctx.channel().id().asShortText();
		users.remove(ctx.channel());
		log.info("客户端被移除，channelId为：{}" , channelId);
	}

	/**
	 * 发生异常之后关闭连接（关闭channel），随后从ChannelGroup中移除
	 * @param ctx 出异常的通道
	 * @param cause 异常信息
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
		cause.printStackTrace();
		ctx.channel().close();
		users.remove(ctx.channel());
	}

	/**
	 * 发送单聊消息至客户端
	 * @param chatBody  消息包
	 * @return 发送结果,成功为true
	 */
	public static boolean sendSingleMessage(ChatBody chatBody){
		// 从全局用户Channel关系中获取接受者的channel
		Channel receiverChannel = UserChannelBind.getChannel(chatBody.getReceiverId());
		if (ObjectUtil.isNotNull(receiverChannel)) {
			// 当receiverChannel不为空的时候，从ChannelGroup去查找对应的channel是否存在
			Channel findChannel = MessageHandler.users.find(receiverChannel.id());
			if (ObjectUtil.isNotNull(findChannel)) {
				// 用户在线
				receiverChannel.writeAndFlush(
						new TextWebSocketFrame(JSONUtil.toJsonStr(chatBody)));
				return Boolean.TRUE;
			}else{
				// TODO 用户不在线,离线消息处理............
			}
		}else{
			// TODO 用户不在线,离线消息处理............
		}
		return Boolean.FALSE;
	}
}
