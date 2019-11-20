package com.hzihui.virgo.netty.strategy;
import com.hzihui.virgo.netty.constant.ChatType;
import com.hzihui.virgo.netty.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 聊天类型工厂
 * 根据当前聊天类型 {@link ChatType} 获取对应的servicce
 * @author HZI.HUI
 * @since 2019/9/23
 */
@Component
public class ChatServiceFactory {

    private static Map<String, ChatService> chatServiceMap;

    /**
     * 获取ChatService 接口类的所有实现类
     * @param chatServiceMap
     */
    @Autowired
    public void setMessageServiceMap(Map<String, ChatService> chatServiceMap) {
        ChatServiceFactory.chatServiceMap = chatServiceMap;
    }

    /**
     * 将默认的无参构造设为私有,
     * 使外界无法通过new 实例本工厂
     */
    private ChatServiceFactory(){}

    public static ChatService getChatService(String type){
        // 根据客户端传入的聊天类型获取对应的service
        ChatService chatService = chatServiceMap.get(type);
        return chatService == null ? chatServiceMap.get(ChatType.EMPTY_MESSAGE_SERVICE) : chatService;
    }
}
