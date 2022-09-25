package com.company.commandServer;

import com.company.drag.Dragon;
import com.company.server.StorageManager;
import com.company.utily.CommandLine;

import java.time.LocalDateTime;

/**
 * 	•	insert null {element}: добавить новый элемент с заданным ключом
 */


public class InsertNullCommand implements Command {
    public CommandLine execute(CommandLine commandLine){



        Dragon dragon = new Dragon();
        try {
            StorageManager.putDragon(Long.parseLong(commandLine.args.get(0)), dragon );
            dragon.setCreationDate(LocalDateTime.now());
            System.out.printf("command '%s' executed\n",commandLine.command );
        } catch (Exception e){
            commandLine.servAnswer = "This key can't be excepted";
            System.out.printf("command '%s' wasn't executed\n",commandLine.command );
        }
        commandLine.serverWaitForAnswer = false;
        return commandLine;
    }
}