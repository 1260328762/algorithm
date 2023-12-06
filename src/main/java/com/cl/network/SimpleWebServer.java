package com.cl.network;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chenliang
 * @since 2023/12/5 19:27
 */
public class SimpleWebServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);

        while (true) {
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            byte[] bytes = new byte[1024 * 1024];
            int read = inputStream.read(bytes);
            if (read > 0) {
                System.out.println(new String(bytes, 0, read));

                OutputStream outputStream = accept.getOutputStream();
                String body = "<h1>hello</h1>";
                String header = "HTTP/1.1 200 OK\n" +
                        "Content-Type: text/html\n" +
                        "Content-Length: " + body.getBytes().length + "\n" +
                        "\n" +
                        body +
                        "\n";

                outputStream.write(header.getBytes());
                outputStream.flush();
                outputStream.close();
            }
        }
    }
}
