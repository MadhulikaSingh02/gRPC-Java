package org.example.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.service.UserLoginService;

import java.io.IOException;

public class GRPCServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8085).addService(new UserLoginService()).build();
        server.start();
        System.out.println("Server has started on "+server.getPort());
        server.awaitTermination();
    }
}
