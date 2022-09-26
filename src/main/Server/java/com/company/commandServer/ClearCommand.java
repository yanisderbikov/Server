package com.company.commandServer;

import com.company.data.StorageManager;
import com.company.utily.CommandLine;

public class ClearCommand implements Command {

    public CommandLine execute(CommandLine commandLine){


        System.out.println("выполняется метод Clear ");

        for (var pair : StorageManager.getDragons().entrySet()){
            if (pair.getValue().getClientName().equals(commandLine.clientName)){
                StorageManager.deliteDragon(pair.getKey());
            }
        }

        commandLine.serverWaitForAnswer = false;
        commandLine.servAnswer = "Коллекция очищена";
        return commandLine;
    }
}
