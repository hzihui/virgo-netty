package com.hzihui.virgo.netty.packets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 聊天消息包
 * @author HZI.HUI
 * @since 2019/11/18
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatBody implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 发送者用户id
     */
    private String senderId;
    /**
     * 接收者用户id
     */
    private String receiverId;
    /**
     * 消息内容
     */
    private String msgContent;
    /**
     * 消息内容类型,text-文本消息,image-图片消息
     */
    private String msgType;
    /**
     * 群组Id;
     */
    private String groupId;
    /**
     * 聊天类型,group-群聊、single-单聊、heartbeat-心跳、bind-用户与通道绑定
     */
    private String chatType;
}
