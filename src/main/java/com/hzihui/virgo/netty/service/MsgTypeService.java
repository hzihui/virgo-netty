package com.hzihui.virgo.netty.service;
import com.hzihui.virgo.netty.packets.ChatBody;

/**
 * 消息内容类型(文字、图片、语音)
 * @author HZI.HUI
 * @since 2019/9/24
 */
public interface MsgTypeService {

    /**
     * 处理消息内容
     * @param chatBody
     * @return
     */
    ChatBody handlerChat(ChatBody chatBody);
}
