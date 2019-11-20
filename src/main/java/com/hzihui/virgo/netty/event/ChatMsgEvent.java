package com.hzihui.virgo.netty.event;

import org.springframework.context.ApplicationEvent;

/**
 * 聊天消息事件
 * @author HZI.HUI
 * @since 2019/11/18
 */
public class ChatMsgEvent extends ApplicationEvent {

    public ChatMsgEvent(Object source) {
        super(source);
    }
}
