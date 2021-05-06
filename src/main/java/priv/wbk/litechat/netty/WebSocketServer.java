package priv.wbk.litechat.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created on 2021/5/4.
 *
 * @author wbk
 * @email 3207264942@qq.com
 */
@Component
@Slf4j
public class WebSocketServer {

    private static volatile WebSocketServer mInstance;

    private final ServerBootstrap serverBootstrap;
    private ChannelFuture channelFuture;

    private WebSocketServer() {
        EventLoopGroup mainGroup = new NioEventLoopGroup();
        EventLoopGroup subGroup = new NioEventLoopGroup();
        serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(mainGroup, subGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new WebSocketServerInitializer());
    }

    public void start() {
        this.channelFuture = serverBootstrap.bind(8088);
        log.info("netty websocket server:8088 启动完毕...");
    }

    public static WebSocketServer getInstance() {
        if (mInstance == null) {
            synchronized (WebSocketServer.class) {
                if (mInstance == null) {
                    mInstance = new WebSocketServer();
                }
            }
        }
        return mInstance;
    }
}
