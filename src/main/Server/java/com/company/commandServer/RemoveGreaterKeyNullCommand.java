package com.company.commandServer;

import com.company.drag.Dragon;
import com.company.data.StorageManager;
import com.company.utily.CommandLine;

import java.util.LinkedHashMap;


/**
 * remove_greater_key null
 * удалить из коллекции все элементы, ключ которых превышает заданный
 */

public class RemoveGreaterKeyNullCommand implements Command {
    public CommandLine execute(CommandLine commandLine){
// TODO: 26.09.2022 реализовать правильнуа сортировку
        System.out.println();
        try{
            long key = Long.parseLong(commandLine.args.get(0));
//            LinkedHashMap<Long, Dragon> dragons;
//            dragons = StorageManager.getDragons();
//            dragons = dragons.entrySet().stream()
//                    .filter(e1 -> e1.getValue().getClientName().equals(commandLine.clientName))
//                    .filter(e1 -> e1.getKey() > key)
//                    .collect(Collectors.toMap(
//                            Map.Entry::getKey, Map.Entry::getValue,
//                            (e1,e2)->e1, LinkedHashMap::new));
//            StorageManager.updateMap(dragons);
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
                .filter(k -> k > key)
                .filter(k -> dragons.get(k).getClientName().equals(CL.clientName))
                .peek(StorageManager::deleteDragon)
                .toList();
    }
}
