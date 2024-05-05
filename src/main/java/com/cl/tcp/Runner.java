package com.cl.tcp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.websocket.server.ServerContainer;

/**
 * @author chenliang
 * @since 2024/5/5 20:22
 */
@Component
public class Runner implements ApplicationRunner {

    @Autowired
    private ServletContext servletContext;

    private ServerContainer serverContainer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        serverContainer =
                (ServerContainer) servletContext.getAttribute("javax.websocket.server.ServerContainer");

        serverContainer.addEndpoint(WebSocketServer.class);

    }
}
