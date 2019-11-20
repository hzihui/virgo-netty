package com.hzihui.virgo.netty.service.impl;
import com.hzihui.virgo.netty.constant.MsgType;
import com.hzihui.virgo.netty.packets.ChatBody;
import com.hzihui.virgo.netty.service.MsgTypeService;
import org.springframework.stereotype.Service;

/**
 * 处理语音消息
 * @author HZI.HUI
 * @since 2019/9/24
 */
@Service(MsgType.AUDIO_MSG_SERVICE)
public class AudioMsgServiceImpl implements MsgTypeService {

    @Override
    public ChatBody handlerChat(ChatBody chatBody){
        System.out.println("处理语音消息。。。。。。。。。。。。。。。");
        return chatBody;
    }
}
