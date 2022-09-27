package com.company.commandServer;


import com.company.data.StorageManager;
import com.company.drag.Dragon;
import com.company.utily.CommandLine;

import java.util.LinkedHashMap;

/**
 * filter_less_than_view view :  вывести элементы, значение поля view
 *                              которых меньше заданного
 */

public class FilterLessThanViewViewCommand implements Command {
    public CommandLine execute(CommandLine commandLine){
        System.out.printf("command '%s' is running\n",commandLine.command );
        try{
            long key = Long.parseLong(commandLine.args.get(0));
            commandLine = filter(key, commandLine);
            commandLine.serverWaitForAnswer = false;
            System.out.printf("command '%s' executed\n",commandLine.command );
        }catch (Exception e){
            commandLine.servAnswer = "this is not a (long)";
            System.out.printf("command '%s' doesn't executed\n",commandLine.command );
        }
        return commandLine;
    }

    CommandLine filter(long key, CommandLine CL){
        LinkedHashMap<Long, Dragon> dragons = StorageManager.getDragons();
        var list = dragons.entrySet()
                .stream()
                .flatMap(k -> k.getKey().describeConstable().stream())
                .filter(k -> k < key)
                .toList();
        StringBuilder builder = new StringBuilder("");
        list.forEach(e -> builder.append(StorageManager.getDragon(e).toString() + "/n"));
        CL.servAnswer = builder.toString();
        return CL;
    }
}