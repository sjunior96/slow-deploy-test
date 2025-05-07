package com.example;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class App {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new java.net.InetSocketAddress(8080), 0);
        server.createContext("/", new MyHandler());
        System.out.println("Server started at: http://" + InetAddress.getLocalHost().getHostAddress() + ":8080");
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "Hello! Your connection is working.";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}