package com.company.commandServer;

import com.company.drag.Dragon;
import com.company.data.StorageManager;
import com.company.utily.CommandLine;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * удалить из коллекции все элементы, ключ которых превышает заданный
 */

public class RemoveGreaterKeyNullCommand implements Command {
    public CommandLine execute(CommandLine commandLine){
//        try {
//            long givenKey = Long.parseLong(commandLine.args.get(0));
//            var dragons = StorageManager.getDragons();
//            for (var pair : dragons.entrySet()){
//                long key = pair.getKey();
//                if (key > givenKey){
//                    dragons.remove(key, pair.getValue());
//                }
//            }
//            commandLine.servAnswer = "все элементы, выше чем '" + givenKey + "' удалены";
//        }catch (Exception e){
//            commandLine.servAnswer = "Can't except that value" + commandLine.args.get(0);
//        }
//        commandLine.serverWaitForAnswer = false;
//        commandLine.needArgs = false;
//        System.out.println("выполняется метод remove greater key");
//        return null;

        try{
            long key = Long.parseLong(commandLine.args.get(0));
            LinkedHashMap<Long, Dragon> dragons = new LinkedHashMap<>();
            dragons.entrySet().stream()
                    .filter(e1 -> e1.getKey() > key)
                    .collect(Collectors.toMap(
                            Map.Entry::getKey, Map.Entry::getValue,
                            (e1,e2)->e1, LinkedHashMap::new));
            StorageManager.updateMap(dragons);

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
}