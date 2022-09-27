package com.company.server;

import com.company.utily.CommandLine;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static com.company.server.ServerRunner.SLIDER;


public class ServerTcpTransport {

    ServerManager serverManager = new ServerManager();
    static boolean isTrue = true;

    public static void setIsTrue(boolean isTrue) {
        ServerTcpTransport.isTrue = isTrue;
    }

    public void execute() throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(9000);
        System.out.println("Server started ");
        while (isTrue) {
            Socket clientSocket = serverSocket.accept();

            ServerRunner serverRunner = new ServerRunner(clientSocket, serverManager);
            Thread thread = new Thread(serverRunner);
            thread.start();

        }
    }
}