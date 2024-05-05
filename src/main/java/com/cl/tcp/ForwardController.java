package com.cl.tcp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.Socket;

/**
 * @author chenliang
 * @since 2024/5/5 19:58
 */
@RestController
public class ForwardController {

    Socket mysqlSocket;

    @RequestMapping("/forward")
    public void forward(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 连接到 MySQL 服务器
        if (mysqlSocket == null) {
            mysqlSocket = new Socket("114.132.201.51", 3306);
        }
        ServletInputStream inputStream = request.getInputStream();

        // 将接收到的数据转发到MySQL服务
        // new AlgorithmApplication.StreamCopier(inputStream, mysqlSocket.getOutputStream()).run();

        // 将MySQL响应数据转发到http输出
        ServletOutputStream outputStream = response.getOutputStream();
        // new AlgorithmApplication.StreamCopier(mysqlSocket.getInputStream(), outputStream).run();
        System.out.println("数据请求已转发");
        outputStream.close();
    }
}
