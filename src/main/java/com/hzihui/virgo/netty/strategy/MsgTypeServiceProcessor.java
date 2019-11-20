package com.hzihui.virgo.netty.strategy;

import com.hzihui.virgo.netty.packets.ChatBody;
import com.hzihui.virgo.netty.service.MsgTypeService;

/**
 * 聊天消息类型处理类
 * @author HZI.HUI
 * @since 2019/9/24
 */
public class MsgTypeServiceProcessor {

    private MsgTypeService msgTypeService;

    public MsgTypeServiceProcessor(MsgTypeService msgTypeService){
        this.msgTypeService = msgTypeService;
    }

    public ChatBody handlerChat(ChatBody chatBody){
       return msgTypeService.handlerChat(chatBody);
    }
}
