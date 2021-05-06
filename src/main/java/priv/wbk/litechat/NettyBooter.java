package priv.wbk.litechat;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import priv.wbk.litechat.netty.WebSocketServer;

/**
 * Created on 2021/5/6.
 *
 * @author wbk
 * @email 3207264942@qq.com
 */
@Component
public class NettyBooter implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            try {
                WebSocketServer.getInstance().start();
            } catch (Exception e) {

            }
        }
    }
}
