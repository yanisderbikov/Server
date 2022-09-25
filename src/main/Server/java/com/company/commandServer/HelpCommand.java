package com.company.commandServer;


import com.company.server.ServerManager;
import com.company.utily.CommandLine;

import java.util.Set;

/**
 * 	•	help: вывести справку по доступным командам
 */

public class HelpCommand implements Command {
    ServerManager serverManager;

    public HelpCommand(ServerManager serverManager) {
        this.serverManager = serverManager;
    }

    public CommandLine execute(CommandLine commandLine){
        //  вызывается переменные БД и ее метод из БД
        System.out.println("running HelpCommand\n-----------------");
        Set<String> set = serverManager.getKeysSetCommand();
        StringBuilder builder = new StringBuilder("");
        for (String str : set){
            builder.append(str + "\n");
        }
//        отправляемые данные серверу
        commandLine.servAnswer = builder.toString();
        commandLine.serverWaitForAnswer = false;
        System.out.printf("command '%s' executed\n",commandLine.command );
        return commandLine;
    }
}



