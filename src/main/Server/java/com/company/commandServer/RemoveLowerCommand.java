package com.company.commandServer;


import com.company.drag.Dragon;
import com.company.data.StorageManager;
import com.company.utily.CommandLine;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * • remove_lower {element} :   удалить из коллекции все элементы,
 *                              меньшие, чем заданный
 */

public class RemoveLowerCommand implements Command {
    // TODO: 25.09.2022 какой-то баг, почему-то удаляет все нах
    public CommandLine execute(CommandLine commandLine){
        try{
            long key = Long.parseLong(commandLine.args.get(0));
            filter(key, commandLine);
            commandLine.servAnswer = "filtered";
            commandLine.serverWaitForAnswer = false;
            System.out.printf("command '%s' executed\n",commandLine.command );
            return commandLine;
        }catch (Exception e){
            commandLine.needArgs = true;
            commandLine.servAnswer = "this is not a (long)";
            return commandLine;
        }

    }

    void filter(long key, CommandLine CL){
        LinkedHashMap<Long, Dragon> dragons = StorageManager.getDragons();
        var d = dragons.entrySet()
                .stream()
                .flatMap(k -> k.getKey().describeConstable().stream())
                .filter(k -> k < key)
                .filter(k -> dragons.get(k).getClientName().equals(CL.clientName))
                .peek(StorageManager::deliteDragon)
                .toList();
    }
}