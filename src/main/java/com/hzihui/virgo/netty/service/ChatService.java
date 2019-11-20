package com.hzihui.virgo.netty.service;

import com.hzihui.virgo.netty.packets.ChatBody;
import io.netty.channel.Channel;

/**
 * 聊天类型(单聊、群聊)
 * @author HZI.HUI
 * @since 2019/9/23
 */
public interface ChatService {

    /**
     * 处理接收消息
     */
    void handleReceiveMessage(ChatBody chatBody, Channel channel);

}
