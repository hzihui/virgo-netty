package com.hzihui.virgo.netty.service.impl;
import com.hzihui.virgo.netty.constant.MsgType;
import com.hzihui.virgo.netty.packets.ChatBody;
import com.hzihui.virgo.netty.service.MsgTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 空类型
 * @author HZI.HUI
 * @since 2019/9/24
 */
@Slf4j
@Service(MsgType.EMPTY_MSG_SERVICE)
public class EmptyMsgServiceImpl implements MsgTypeService {
    @Override
    public ChatBody handlerChat(ChatBody chatBody) {
        log.warn("目前没有提供该类型的消息处理类：" + chatBody.getMsgType());
        return null;
    }
}
