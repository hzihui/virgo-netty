package com.hzihui.virgo.netty.strategy;

import com.hzihui.virgo.netty.constant.MsgType;
import com.hzihui.virgo.netty.service.MsgTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 消息内容类型工厂
 * @author HZI.HUI
 * @since 2019/9/24
 */
@Component
public class MsgTypeFactory {

    private static Map<String, MsgTypeService> msgTypeServiceMap;

    @Autowired
    public void setMsgTypeServiceMap(Map<String, MsgTypeService> msgTypeServiceMap) {
        MsgTypeFactory.msgTypeServiceMap = msgTypeServiceMap;
    }

    private MsgTypeFactory(){}

    public static MsgTypeService getMsgTypeService(String type){
        MsgTypeService msgTypeService = msgTypeServiceMap.get(type);
        return msgTypeService == null ? msgTypeServiceMap.get(MsgType.EMPTY_MSG_SERVICE) : msgTypeService;
    }


}
