package com.company.server;

import com.company.utily.CommandLine;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerRunner implements Runnable{
    final static String SLIDER = "------------------------------";

    Socket clientSocket;
    ServerManager serverManager;
    public ServerRunner(Socket clientSocket, ServerManager serverManager) {
        this.clientSocket = clientSocket;
        this.serverManager = serverManager;
    }

    @Override
    public void run() {

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
            e.printStackTrace();
            System.out.println("Shit Happened");
        }
    }
}
