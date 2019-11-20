package com.hzihui.virgo.netty.handle;

import com.google.common.collect.Maps;
import io.netty.channel.Channel;

import java.util.Map;

/**
 * 用户与消息通道绑定关系
 * @author HZI.HUI
 * @since 2019/9/23
 */
public class UserChannelBind {

    private final static Map<String, Channel> USER_CHANNEL_LIST = Maps.newConcurrentMap();

    /**
     * 添加用户和消息通道的绑定关系
     * @param userId
     * @param channel
     */
    public static void bind(String userId,Channel channel){
        USER_CHANNEL_LIST.put(userId,channel);
        getChannelList();
    }

    /**
     * 根据用户id获取消息通道id
     * @param userId
     * @return
     */
    public static Channel getChannel(String userId){
        return USER_CHANNEL_LIST.get(userId);
    }

    /**
     * 获取所有通道连接信息
     */
    public static void getChannelList(){
        USER_CHANNEL_LIST.forEach( (k,v)-> {
            System.out.println("key:"+k+" value:"+v);
        });
    }
}
