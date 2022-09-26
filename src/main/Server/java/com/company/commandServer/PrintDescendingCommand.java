package com.company.commandServer;

import com.company.drag.Dragon;
import com.company.data.StorageManager;
import com.company.utily.CommandLine;

import java.util.*;
import java.util.stream.Collectors;

/**
 * print_descending : вывести элементы коллекции в порядке убывания
 */

public class PrintDescendingCommand implements Command {
    public CommandLine execute(CommandLine commandLine){
        System.out.println("running 'print descending'");
        LinkedHashMap<Long, Dragon> dragons = StorageManager.getDragons();
        dragons = dragons.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e1.getKey() , -e2.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1,e2)->e1, LinkedHashMap::new));
        StringBuilder builder = new StringBuilder("");
        dragons.entrySet().stream()
                .forEach(e1 -> builder.append(e1.getValue().toString()+"\n"));

        commandLine.servAnswer = builder.toString();
        commandLine.serverWaitForAnswer = false;
        System.out.printf("command '%s' executed\n",commandLine.command );
        return commandLine;
    }
}