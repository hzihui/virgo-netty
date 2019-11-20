package com.hzihui.virgo.netty.listener;

import com.hzihui.virgo.netty.event.ChatMsgEvent;
import com.hzihui.virgo.netty.packets.ChatBody;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author HZI.HUI
 * @since 2019/11/18
 */
@Component
public class ChatMsgListener{


    @EventListener
    public void chatMsgEvent(ChatMsgEvent chatMsgEvent) {
        ChatBody chatBody = (ChatBody)chatMsgEvent.getSource();
        System.out.println("监听到消息事件发布出来的消息");
    }
}
