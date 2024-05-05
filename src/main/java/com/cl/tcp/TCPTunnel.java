package com.cl.tcp;

import javax.websocket.Session;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenliang
 * @since 2024/5/5 19:24
 */
public class TCPTunnel {

    public static void main(String[] args) throws Exception {
        int localPort = 3306; // 本地 HTTP 服务端口

        ServerSocket serverSocket = new ServerSocket(localPort);
        System.out.println("TCP隧道开启，端口号：" + localPort);
        while (true) {
            Socket clientSocket = serverSocket.accept(); // 接受来自客户端的连接
            System.out.println("客户端已连接");

            // 与WebSocket建立连接;
            Session session = WebSocketClient.start(clientSocket);

            InputStream inputStream = clientSocket.getInputStream();

            // 读取socket客户端消息
            new Thread(() -> {
                while (true) {
                    try {
                        byte[] buffer = new byte[10485760];
                        int bytesRead;

                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            System.out.println("读取到socket客户端消息：" + new String(buffer, 0, bytesRead));
                            session.getBasicRemote().sendBinary(ByteBuffer.wrap(buffer, 0, bytesRead));
                            System.out.println("socket客户端消息发送至ws成功");
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();

        }
    }


    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        AtomicInteger atomicInteger = new AtomicInteger(1);

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // 读取客户端发送的数据
                InputStream clientInput = clientSocket.getInputStream();
                OutputStream clientOutput = clientSocket.getOutputStream();

                sendInit(clientOutput);

                while (true) {
                    // 转发数据到HTTP服务器
                    URL url = new URL("http://127.0.0.1:15004/znm/b-card/query");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setDoOutput(true);
                    connection.setRequestProperty("Connection", "Keep-Alive");

                    OutputStream httpOutput = connection.getOutputStream();

                    byte[] buffer = new byte[1024];
                    int bytesRead;

                    while ((bytesRead = clientInput.read(buffer)) != -1) {
                        httpOutput.write(buffer, 0, bytesRead);
                    }
                    httpOutput.close();

                    // 接收HTTP服务器响应
                    InputStream httpInput = connection.getInputStream();

                    // 转发HTTP服务器响应数据到客户端
                    while ((bytesRead = httpInput.read(buffer)) != -1) {
                        clientOutput.write(buffer, 0, bytesRead);
                        clientOutput.flush();
                    }

                    // clientOutput.write(new byte[]{0, 0, 0});

                    // 关闭HTTP连接，保持TCP连接不关闭
                    httpInput.close();
                    connection.disconnect();
                    clientOutput.flush();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        private void sendInit(OutputStream clientOutput) throws Exception {
            // 转发数据到HTTP服务器
            URL url = new URL("http://127.0.0.1:15004/znm/b-card/query");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Connection", "Keep-Alive");

            OutputStream httpOutput = connection.getOutputStream();
            httpOutput.write(1);
            httpOutput.close();


            InputStream httpInput = connection.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            // 转发HTTP服务器响应数据到客户端
            while ((bytesRead = httpInput.read(buffer)) != -1) {
                clientOutput.write(buffer, 0, bytesRead);
                clientOutput.flush();
            }
        }
    }


    static class StreamCopier implements Runnable {
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
                try {
                    inputStream.close();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    // public static void main(String[] args) throws IOException {
    //     int localPort = 8080; // 本地 HTTP 服务端口
    //     String mysqlHost = "192.168.20.143";
    //     int mysqlPort = 3306; // MySQL 服务端口
    //
    //     ServerSocket serverSocket = new ServerSocket(localPort);
    //     System.out.println("TCP tunnel listening on port " + localPort);
    //
    //     while (true) {
    //         Socket clientSocket = serverSocket.accept(); // 接受来自客户端的连接
    //
    //         // 连接到 MySQL 服务器
    //         Socket mysqlSocket = new Socket(mysqlHost, mysqlPort);
    //
    //         // 启动两个线程进行数据转发
    //         Thread clientToMysql = new Thread(new StreamCopier(clientSocket.getInputStream(), mysqlSocket.getOutputStream()));
    //         Thread mysqlToClient = new Thread(new StreamCopier(mysqlSocket.getInputStream(), clientSocket.getOutputStream()));
    //
    //         clientToMysql.start();
    //         mysqlToClient.start();
    //     }
    // }
    //
    // static class StreamCopier implements Runnable {
    //     private InputStream inputStream;
    //     private OutputStream outputStream;
    //
    //     public StreamCopier(InputStream inputStream, OutputStream outputStream) {
    //         this.inputStream = inputStream;
    //         this.outputStream = outputStream;
    //     }
    //
    //     @Override
    //     public void run() {
    //         try {
    //             byte[] buffer = new byte[4096];
    //             int bytesRead;
    //             while ((bytesRead = inputStream.read(buffer)) != -1) {
    //                 outputStream.write(buffer, 0, bytesRead);
    //                 outputStream.flush();
    //             }
    //         } catch (IOException e) {
    //             e.printStackTrace();
    //         } finally {
    //             try {
    //                 inputStream.close();
    //                 outputStream.close();
    //             } catch (IOException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     }
    // }

}
