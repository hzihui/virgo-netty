package com.hzihui.virgo.netty.service.impl;

import com.hzihui.virgo.netty.config.MessageHandler;
import com.hzihui.virgo.netty.constant.ChatType;
import com.hzihui.virgo.netty.handle.UserChannelBind;
import com.hzihui.virgo.netty.packets.ChatBody;
import com.hzihui.virgo.netty.service.ChatService;
import io.netty.channel.Channel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 单聊消息业务处理
 * @author HZI.HUI
 * @since 2019/9/23
 */
@Service(value = ChatType.BIND_CHAT_SERVICE)
@RequiredArgsConstructor
public class BindChatServiceImpl implements ChatService {

    /**
     * 处理接收bind-用户与通道绑定消息进行绑定
     * @param chatBody 消息包
     * @param channel 消息通道
     */
    @Override
    public void handleReceiveMessage(ChatBody chatBody, Channel channel) {
        //用户与聊天通道进行绑定
        UserChannelBind.bind(chatBody.getSenderId(),channel);
        chatBody.setMsgContent("用户与聊天通道绑定成功");
        //发送消息到客户端
        MessageHandler.sendSingleMessage(chatBody);
    }

}
