package com.company.commandServer;

import com.company.data.StorageManager;
import com.company.utily.CommandLine;

public class ClearCommand implements Command {

    public CommandLine execute(CommandLine commandLine){


        System.out.println("выполняется метод Clear ");

//        for (var pair : StorageManager.getDragons().entrySet()){
//            if (pair.getValue().getClientName().equals(commandLine.clientName)){
//                StorageManager.deliteDragon(pair.getKey());
//            }
//        }

        var list =
                StorageManager.getDragons().entrySet().stream()
                .flatMap(k -> k.getKey().describeConstable().stream())
                .filter(k -> StorageManager.getDragons().get(k).getClientName().equals(commandLine.clientName))
                .toList();
//                .forEach(StorageManager::deliteDragon);
        list.forEach(StorageManager::deleteDragon);

        commandLine.serverWaitForAnswer = false;
        commandLine.servAnswer = "Коллекция очищена";
        return commandLine;
    }
}
