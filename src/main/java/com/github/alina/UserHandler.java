package com.github.alina;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class UserHandler implements HttpHandler {
    Map<Integer, User> userMap = new HashMap<>();

    public UserHandler() {
        userMap.put(1, new User(1, "Alina", "alina@gmail.com"));
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if(exchange.getRequestMethod().equals("GET")){
            handleGetRequest(exchange);
        }

    }
    public Headers handleGetRequest(HttpExchange exchange) throws IOException {
        //extract one user from map to be used in the response header
        String response= userMap.get(1).toString();

        // Response code and length
        exchange.sendResponseHeaders(200, response.getBytes().length);
        // Set additional response header name of the header and value
        exchange.getResponseHeaders().set("content-type", "application/json");
// ""
        try (OutputStream stream = exchange.getResponseBody()) {
            stream.write(response.getBytes());
        }

        return exchange.getResponseHeaders();
    }

}
