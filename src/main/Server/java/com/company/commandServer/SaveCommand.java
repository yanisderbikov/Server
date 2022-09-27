package com.company.commandServer;

import com.company.data.StorageManager;
import com.company.utily.CommandLine;

/**
 * save : сохранить коллекцию в файл
 */

public class SaveCommand implements Command {
    public CommandLine execute(CommandLine commandLine) {
        System.out.println("выполняется метод save");
        try {

            StorageManager.sortDragons(); // в методе релализовано сохранение в файл

            commandLine.serverWaitForAnswer = false;
            commandLine.servAnswer = "Collection was saved to file 'save.xml'";
            System.out.printf("command '%s' executed\n",commandLine.command );
            return commandLine;

        } catch (Exception e) {
            e.printStackTrace();
            commandLine.servAnswer = "Command wasn't execute";
            commandLine.serverWaitForAnswer = false;
            return commandLine;
        }

    }
}
