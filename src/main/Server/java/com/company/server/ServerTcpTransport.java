package com.company.server;


import com.company.utily.CommandLine;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerTcpTransport {
    final static String SLIDER = "------------------------------";

    ServerManager serverManager = new ServerManager();

    public void execute() throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(9000);
        System.out.println("Server started ");
        while (true) {
            Socket clientSocket = serverSocket.accept();

            ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());

            CommandLine commandLine = null;
            // TODO: 15.09.2022 crash here
            //  может быть исользовать что-то другое, а не ObjectInputStream

            try {
                commandLine = (CommandLine) objectInputStream.readObject();
            }catch (ClassNotFoundException e){
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


        }
    }
}