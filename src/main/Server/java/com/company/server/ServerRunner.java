package com.company.server;

import com.company.utily.CommandLine;

import java.io.IOException;
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
            assert commandLine != null;
            if (commandLine.command.equals("stop_server")){
                 ServerTcpTransport.setIsTrue(false);
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
            commandLine.servAnswer = "Error/serverStopped";
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                objectOutputStream.writeObject(commandLine);
                objectOutputStream.flush();
                objectOutputStream.close();
                clientSocket.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
            System.out.println("Shit Happened in ServerTcpTransport");
        }
    }
}
