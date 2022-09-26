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
        System.out.println("выполняется метод remove lower");
        try{
            long key = Long.parseLong(commandLine.args.get(0));
            LinkedHashMap<Long, Dragon> dragons = new LinkedHashMap<>();
            dragons.entrySet().stream()
                    .filter(e1 -> e1.getKey()<key)
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