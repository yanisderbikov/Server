package com.company.commandServer;

import com.company.server.StorageManager;
import com.company.utily.CommandLine;

public class ClearCommand implements Command {

    public CommandLine execute(CommandLine commandLine){

        System.out.println("выполняется метод Clear ");
        StorageManager.getDragons().clear();
        commandLine.serverWaitForAnswer = false;
        commandLine.servAnswer = "Коллекция очищена";
        return commandLine;
    }
}
