package com.hzihui.virgo.netty.service.impl;

import com.hzihui.virgo.netty.config.MessageHandler;
import com.hzihui.virgo.netty.constant.ChatType;
import com.hzihui.virgo.netty.event.ChatMsgEvent;
import com.hzihui.virgo.netty.packets.ChatBody;
import com.hzihui.virgo.netty.service.ChatService;
import com.hzihui.virgo.netty.strategy.BaseProcessor;
import com.hzihui.virgo.netty.utils.SpringContextHolder;
import io.netty.channel.Channel;
import org.springframework.stereotype.Service;

/**
 * 群消息service
 * @author HZI.HUI
 * @since 2019/9/24
 */
@Service(ChatType.GROUP_CHAT_SERVICE)
public class GroupChatServiceImpl implements ChatService {

    /**
     * 接收群消息
     * @param chatBody
     * @return
     */
    @Override
    public void handleReceiveMessage(ChatBody chatBody, Channel channel) {
        //发送消息到接收者用户
        System.out.println("群聊消息处理...........");
        chatBody = BaseProcessor.getChatBody(chatBody);
        //发送消息
        chatBody.setMsgContent("群聊消息服务端处理消息后返回给客户端的消息。。。。。。");
        boolean sendFlag = MessageHandler.sendSingleMessage(chatBody);
        if(sendFlag){
            System.out.println("群聊消息发送成功");
        }else {
            System.out.println("群聊消息发送失败");
        }
        //发布一条消息事件出去做业务处理
        SpringContextHolder.publishEvent(new ChatMsgEvent(chatBody));
    }
}
