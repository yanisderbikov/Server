package com.company.commandServer;

import com.company.data.StorageManager;
import com.company.drag.Dragon;
import com.company.utily.CommandLine;

import java.util.NoSuchElementException;

/**
 * update_id {element} :    обновить значение элемента коллекции,
 *                          id которого равен заданному
 */

public class UpdateIdCommand implements Command {
    public CommandLine execute(CommandLine commandLine){
        System.out.println("выполняется метод updateId");

//        0 параметр ID существуещего
//        1 параметр ID на который нужно замениить
        long key;
        long newKey;
        try {
            key = Long.parseLong(commandLine.args.get(0));
            newKey = Long.parseLong(commandLine.args.get(1));
        }catch (Exception e){
            System.out.println("wrong parameters");
            commandLine.servAnswer = "wrong parameters";
            return commandLine;
        }
        if (StorageManager.check(key)) {
            Dragon dragon = StorageManager.getDragon(key);
            if (commandLine.clientName.equals(dragon.getClientName())){
                dragon.setId(newKey);
                commandLine.servAnswer = "you changed id '" + dragon.getName() + "'";

            }else {
                commandLine.servAnswer = "you can't change this obj";
            }
        }else {
            commandLine.servAnswer = "no such dragon id";
        }
        StorageManager.sortDragons();
        commandLine.serverWaitForAnswer = false;
        System.out.printf("command '%s' executed\n",commandLine.command );
        return commandLine;
    }
}
