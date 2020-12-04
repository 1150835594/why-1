package socket;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * 用于处理消息的服务类
 */
@ServerEndpoint("/chat") //只有加了该注解，则表示当前是一个socket的服务类，它才可以在服务器启动时，被配置类 扫描
//websocket发送的是websocket请求，不是http请求
//所以，要访问当前的socket服务，请求方式 ：  ws://ip地址:端口/chat
public class ChatSocket {


    @OnOpen //加了该注解的方法，将会在客户端与服务器端建立连接（握手）的时候，会被调用,参数session:即为建立好连接（通信管道）
    public void open(Session ses){
        System.out.println("--------正在建立连接-----------");
        System.out.println("连接创建，当前连接的管道编号是:"+ses.getId());
    }

    @OnMessage //加了该注解的方法，将会在接收到客户端的消息时，自动调用
    public void showMsg(Session ses,String msg) throws IOException {
        //session:哪一个管道的发送的消息
        //msg:接收到的消息内容

        System.out.println("接收到来自至于管道编号为"+ses.getId()+"的消息:"+msg);

        //通过管道返回消息: 哪一个管道发送的消息，就通过哪一个管道来返回
        ses.getBasicRemote().sendText("服务器已经接收到你的消息:"+msg);
    }



}
