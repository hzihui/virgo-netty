package com.hzihui.virgo.netty.config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * netty properties configuration
 * @author HZI.HUI
 * @since 2019/11/20
 */
@Data
@Component
@ConfigurationProperties(prefix = "virgo.netty")
public class NettyProperties {

    /**
     * 端口号
     */
    private Integer post = 8868;

    /**
     * ip
     */
    private String host = "localhost";

    /**
     * websocket访问路由
     */
    private String websocketPath = "/";

    /**
     * 进入读消息空闲时间
     */
    private Integer readerIdleTime = 10;

    /**
     * 进入写消息空闲时间
     */
    private Integer writerIdleTime = 10;

    /**
     * 空闲超时时间
     */
    private Integer allIdleTime = 20;
}
