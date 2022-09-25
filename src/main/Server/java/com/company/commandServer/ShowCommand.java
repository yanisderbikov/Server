package com.company.commandServer;

import com.company.drag.Dragon;
import com.company.server.StorageManager;
import com.company.utily.CommandLine;

/**
 * вывести в стандартный поток вывода
 * все элементы коллекции в строковом представлении
 */

public class ShowCommand implements Command {

    public CommandLine execute(CommandLine commandLine){
        System.out.println("выполняется метод ShowCommand");

        StringBuilder builder = new StringBuilder("");

        for (var pair : StorageManager.getDragons().entrySet()){
            Dragon dragon = pair.getValue();
            builder.append(dragon.toString() + "\n");
        }
        commandLine.serverWaitForAnswer = false;
        commandLine.needArgs = false;
        commandLine.servAnswer = builder.toString();
        System.out.printf("command '%s' executed\n",commandLine.command );
        return commandLine;
    }
}
