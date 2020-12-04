package socket;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;
import java.util.Set;

/**
 * 配置类，用于扫描所有的socket服务
 */
public class SocketConfig implements ServerApplicationConfig {

    //以编程的方式，加载所有的socket服务
    @Override
    public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> set) {
        return null;
    }

    //以注解的方式，加载所有socket服务(一般采用注解的方式)
    //当前系统中所有的socket服务，都会放在set集合中加
    @Override
    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> set) {
        System.out.println("正在加载socket服务，目前已经加载服务个数为:"+set.size());
        return set;
    }
}
