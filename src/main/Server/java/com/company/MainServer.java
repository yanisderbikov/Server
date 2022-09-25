package com.company;

import com.company.server.ServerTcpTransport;

public class MainServer {
    public static void main (String [] args)  {
        ServerTcpTransport serverTcpTransport = new ServerTcpTransport();
        try {
            serverTcpTransport.execute();
        } catch (Exception e){
            System.err.println("Уже заебало");
            e.printStackTrace();
        }
    }
}
