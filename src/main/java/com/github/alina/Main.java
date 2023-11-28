package com.github.alina;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create HttpServer which is listening to the given port on the given IP address
        InetAddress localAddress = InetAddress.getByName("127.0.0.1");
        HttpServer server = HttpServer.create(new InetSocketAddress(localAddress, 8080), 0);

        // Create a default context
        HttpContext context = server.createContext("/user", new UserHandler());
        // You can also set up the handler to process requests with the setter:
        // context.setHandler(new MyHttpHandler());

        // Start the server
        server.start();
    }

}