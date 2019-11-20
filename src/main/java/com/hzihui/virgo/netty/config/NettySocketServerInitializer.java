package com.hzihui.virgo.netty.config;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * 服务端通道管道初始化
 * netty socket server initializer configuration
 * @author HZIHUI
 * @since 2019/11/20
 */
public class NettySocketServerInitializer extends ChannelInitializer<SocketChannel> {

	private NettyProperties properties;

	public NettySocketServerInitializer(NettyProperties properties){
		this.properties = properties;
	}

	/**
     * 初始化管道通道
	 * @param ch
	 */
	@Override
	protected void initChannel(SocketChannel ch){
		ChannelPipeline pipeline = ch.pipeline();
		// websocket 基于http协议，所以要有http编解码器
		pipeline.addLast(new HttpServerCodec());
		// 对写大数据流的支持 
		pipeline.addLast(new ChunkedWriteHandler());
		// 对httpMessage进行聚合，聚合成FullHttpRequest或FullHttpResponse
		pipeline.addLast(new HttpObjectAggregator(1024*64));

		// websocket 服务器处理的协议，用于指定给客户端连接访问的路由
		pipeline.addLast(new WebSocketServerProtocolHandler(this.properties.getWebsocketPath()));

		// 如果是读空闲或者写空闲，不处理
		pipeline.addLast(new IdleStateHandler(this.properties.getReaderIdleTime(),
				this.properties.getWriterIdleTime(), this.properties.getAllIdleTime()));
		// 自定义的空闲状态检测
		pipeline.addLast(new HeartBeatHandler());
		
		// 自定义消息处理的handler
		pipeline.addLast(new MessageHandler());
	}

}
