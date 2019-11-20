package com.hzihui.virgo.netty.strategy;

import com.hzihui.virgo.netty.packets.ChatBody;
import com.hzihui.virgo.netty.service.ChatService;
import io.netty.channel.Channel;

/**
 * 聊天类型处理器
 * @author HZI.HUI
 * @since 2019/9/23
 */
public class ChatServiceProcessor {

    private ChatService messageService;

    public ChatServiceProcessor(ChatService messageService){
        this.messageService = messageService;
    }


    public void handleReceiveMessage(ChatBody chatBody, Channel channel){
        this.messageService.handleReceiveMessage(chatBody,channel);
    }
}
