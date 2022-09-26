package com.company.commandServer;

import com.company.drag.Coordinates;
import com.company.drag.Dragon;
import com.company.drag.DragonCave;
import com.company.data.StorageManager;
import com.company.utily.CommandLine;

import java.time.LocalDateTime;

/**
 * 	•	insert null {element}: добавить новый элемент с заданным ключом
 */


public class InsertNullCommand implements Command {
    public CommandLine execute(CommandLine commandLine){


        try {
            Dragon dragon = createNull();
            dragon.setId(Long.parseLong(commandLine.args.get(0)));
            StorageManager.putDragon(Long.parseLong(commandLine.args.get(0)), dragon );
            System.out.printf("command '%s' executed\n",commandLine.command );
        } catch (Exception e){
            commandLine.servAnswer = "This key can't be excepted";
            System.out.printf("command '%s' wasn't executed\n",commandLine.command );
        }
        commandLine.serverWaitForAnswer = false;
        return commandLine;
    }

    Dragon createNull(){
        Dragon dragon = new Dragon();
        dragon.setCoordinates(new Coordinates("0","0"));
        dragon.setCave(new DragonCave(0));
        dragon.setCreationDate(LocalDateTime.now());

        return dragon;
    }
}