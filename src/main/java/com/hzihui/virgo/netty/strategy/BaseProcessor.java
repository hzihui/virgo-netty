package com.hzihui.virgo.netty.strategy;
import com.hzihui.virgo.netty.packets.ChatBody;
import io.netty.channel.Channel;

/**
 * 公共调用Processor类
 * @author HZI.HUI
 * @since 2019/9/24
 */
public class BaseProcessor {

    /**
     * 聊天类型(如群聊、私聊、心跳)Processor
     * @param chatBody
     */
    public static void handleReceiveMessage(ChatBody chatBody, Channel channel){
        ChatServiceProcessor chatServiceProcessor = new ChatServiceProcessor(
                ChatServiceFactory.getChatService(chatBody.getChatType()));
        chatServiceProcessor.handleReceiveMessage(chatBody,channel);
    }


    /**
     * 聊天消息类型;(如图片、语音、文字)Processor
     * @param chatBody
     * @return
     */
    public static ChatBody getChatBody(ChatBody chatBody){
        MsgTypeServiceProcessor msgTypeServiceProcessor = new MsgTypeServiceProcessor(
                MsgTypeFactory.getMsgTypeService(chatBody.getMsgType()));
       return msgTypeServiceProcessor.handlerChat(chatBody);
    }
}
