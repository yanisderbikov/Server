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

    public void execute() throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(9000);
        System.out.println("Server started ");
        while (true) {
            Socket clientSocket = serverSocket.accept();


            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
                CommandLine commandLine = null;

                try {
                    commandLine = (CommandLine) objectInputStream.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                commandLine = serverManager.runCommand(commandLine);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());

                objectOutputStream.writeObject(commandLine);
                objectOutputStream.flush();
                objectInputStream.close();
                objectOutputStream.close();
                clientSocket.close();
                System.out.println(SLIDER);
            } catch (Exception e){
                CommandLine commandLine = new CommandLine();
                commandLine.servAnswer = "Error";
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                objectOutputStream.writeObject(commandLine);
                objectOutputStream.flush();
                objectOutputStream.close();
                clientSocket.close();
                e.printStackTrace();
                System.out.println("Shit Happened in ServerTcpTransport");
            }

//            ServerRunner serverRunner = new ServerRunner(clientSocket, serverManager);
//            Thread thread = new Thread(serverRunner);
//            thread.start();

        }
    }
}