package com.cl.tcp;

/**
 * @author chenliang
 * @since 2024/5/5 19:41
 */

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

@ServerEndpoint("/ws")
public class WebSocketServer {

    private static Socket socket;

    private static OutputStream outputStream;

    @OnOpen
    public void onOpen(Session session) throws Exception {
        System.out.println("ws连接建立: " + session.getId());
        socket = new Socket("114.132.201.51", 3306);

        outputStream = socket.getOutputStream();

        InputStream inputStream = socket.getInputStream();
        new Thread(() -> {
            try {
                while (true) {
                    byte[] buffer = new byte[10485760];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        System.out.println("接收到socket服务端消息: " + new String(buffer, 0, bytesRead));
                        session.getBasicRemote().sendBinary(ByteBuffer.wrap(buffer, 0, bytesRead));
                        System.out.println("socket服务端消息转发至ws客户端成功");
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }).start();
    }

    @OnMessage
    public void onMessage(ByteBuffer message, Session session) throws Exception {
        System.out.println("接收到ws客户端消息 " + new String(message.array()));
        outputStream.write(message.array());
        outputStream.flush();
        System.out.println("ws客户端消息转发至socket成功" + new String(message.array()));
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Client disconnected: " + session.getId());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }

    public static class StreamCopier implements Runnable {
        private InputStream inputStream;
        private OutputStream outputStream;

        public StreamCopier(InputStream inputStream, OutputStream outputStream) {
            this.inputStream = inputStream;
            this.outputStream = outputStream;
        }

        @Override
        public void run() {
            try {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                    outputStream.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // try {
                //     // inputStream.close();
                //     // outputStream.close();
                // } catch (IOException e) {
                //     e.printStackTrace();
                // }
            }
        }
    }
}