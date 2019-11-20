package com.hzihui.virgo.netty.handle;

import com.google.common.collect.Maps;
import io.netty.channel.Channel;

import java.util.Map;

/**
 * 群与消息通道绑定关系
 * @author HZI.HUI
 * @since 2019/9/23
 */
public class GroupChannelBind {

    private final static Map<String,Map<String, Channel>> GROUP_CHANNEL_LIST = Maps.newConcurrentMap();

    /**
     * 添加群和消息通道的绑定关系
     * @param groupId 群id
     * @param userId  用户id
     * @param channel 消息通道
     */
    public static void bind(String groupId,String userId,Channel channel){
        Map<String,Channel> userChannelMap = Maps.newConcurrentMap();
        userChannelMap.put(userId,channel);
        GROUP_CHANNEL_LIST.put(userId,userChannelMap);
    }

    /**
     * 根据群id获取消息通道
     * @param userId
     * @return
     */
    public static Map<String, Channel> getGroupChannel(String userId){
        return GROUP_CHANNEL_LIST.get(userId);
    }
}
