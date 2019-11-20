package com.hzihui.virgo.netty.constant;

/**
 * 聊天消息类型
 * @author HZI.HUI
 * @since 2019/11/18
 */
public interface MsgType {
    /**
     * 文本消息
     */
    String TEXT_MSG_SERVICE =  "text";

    /**
     * 图片消息
     */
    String IMAGE_MSG_SERVICE =  "image";

    /**
     * 语音消息
     */
    String AUDIO_MSG_SERVICE =  "audio";

    /**
     * 空类型消息处理
     */
    String EMPTY_MSG_SERVICE =  "emptyMsg";
}
