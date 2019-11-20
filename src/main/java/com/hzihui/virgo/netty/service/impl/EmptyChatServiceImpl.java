package com.hzihui.virgo.netty.service.impl;

import com.hzihui.virgo.netty.constant.ChatType;
import com.hzihui.virgo.netty.packets.ChatBody;
import com.hzihui.virgo.netty.service.ChatService;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 空消息实现
 * @author HZI.HUI
 * @since 2019/9/23
 */
@Slf4j
@Service(value = ChatType.EMPTY_MESSAGE_SERVICE)
public class EmptyChatServiceImpl implements ChatService {


    @Override
    public void handleReceiveMessage(ChatBody chatBody, Channel channel) {
        log.warn("没有此类型消息处理=============");
    }
}
