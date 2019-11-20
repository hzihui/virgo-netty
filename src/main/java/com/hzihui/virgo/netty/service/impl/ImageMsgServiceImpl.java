package com.hzihui.virgo.netty.service.impl;

import com.hzihui.virgo.netty.constant.MsgType;
import com.hzihui.virgo.netty.packets.ChatBody;
import com.hzihui.virgo.netty.service.MsgTypeService;
import org.springframework.stereotype.Service;

/**
 * 图片消息处理
 * @author HZI.HUI
 * @since 2019/9/24
 */
@Service(MsgType.IMAGE_MSG_SERVICE)
public class ImageMsgServiceImpl implements MsgTypeService {
    @Override
    public ChatBody handlerChat(ChatBody chatBody) {
        System.out.println("处理图片消息");
        return chatBody;
    }
}
