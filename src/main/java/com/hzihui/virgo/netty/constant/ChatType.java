package com.hzihui.virgo.netty.constant;

/**
 * 消息处理service常量
 * @author HZI.HUI
 * @since 2019/11/18
 */
public interface ChatType {

    /**
     * 点对点聊天
     */
   String  SINGLE_CHAT_SERVICE = "single";

    /**
     * 群聊
     */
    String  GROUP_CHAT_SERVICE = "group";

    /**
     * 心跳
     */
    String HEARTBEAT_CHAT_SERVICE = "heartbeat";

    /**
     * 用户与通道绑定
     */
    String BIND_CHAT_SERVICE = "bind";

    /**
     * 空serviceImpl
     */
    String  EMPTY_MESSAGE_SERVICE = "emptyChat";
}
