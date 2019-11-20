package com.hzihui.virgo.netty.config;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * netty 服务
 * @author HZIHUI
 * @since 2019/11/20
 */
@Slf4j
@Component
public class NettyWebSocketServer implements CommandLineRunner {

	@Autowired
	private NettyProperties properties;
	
	private EventLoopGroup mainGroup;
	private EventLoopGroup subGroup;
	private ServerBootstrap server;

	@PostConstruct
	public void init() {
		/*
		 * NioEventLoopGroup 是I/O操作的多线程事件循环器，主要用来处理不同的数据传输
		 * mainGroup 用来接收进来的连接
		 * subGroup 用来处理已经被接收的连接
		 * 处理流程：mainGroup接收到请求后会把连接注册到subGroup
		 */
		this.mainGroup = new NioEventLoopGroup();
		this.subGroup = new NioEventLoopGroup();
		//服务端引导类,用来辅助NIO服务的启动
		this.server = new ServerBootstrap();
		this.server.group(mainGroup, subGroup)
			// 使用NioServerSocketChannel去处理进来的请求
			.channel(NioServerSocketChannel.class)
			// 自定义服务端管道初始化配置类
			.childHandler(new NettySocketServerInitializer(this.properties));

	}

	@Override
	public void run(String... args) {
		// 启动Netty Server
		server.bind(this.properties.getHost(),this.properties.getPost());
		// 打印启动信息
		log.info("Netty Websocket started on post {} with webSocket path '{}'",
				this.properties.getPost(),
				this.properties.getWebsocketPath());
	}
}
