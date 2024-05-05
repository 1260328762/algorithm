package com.cl.tcp;

import javax.websocket.*;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;

@ClientEndpoint
public class WebSocketClient {

    private static Socket socket;

    private  static OutputStream outputStream;

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("与ws服务器建立连接成功");
    }

    @OnMessage
    public void onMessage(ByteBuffer message, Session session) throws Exception {
        System.out.println("接收到WS服务器消息 " + new String(message.array()));
        outputStream.write(message.array());
        outputStream.flush();
        System.out.println("消息已回写至socket客户端");
    }

    public static Session start(Socket clientSocket) throws Exception {
        socket = clientSocket;
        outputStream = clientSocket.getOutputStream();
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        return container.connectToServer(WebSocketClient.class, new URI("ws://127.0.0.1:8080/ws"));
    }
}