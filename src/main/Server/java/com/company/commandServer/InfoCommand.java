package com.company.commandServer;


import com.company.data.StorageManager;
import com.company.utily.CommandLine;

/**
 * 	•	info:   вывести в стандартный поток вывода информацию о коллекции
 * 	            (тип, дата инициализации, количество элементов и т.д.)
 */

public class InfoCommand implements Command {
    @Override
    public CommandLine execute(CommandLine commandLine) {

        StringBuilder builder = new StringBuilder("");
        builder.append("type : LinkedHashMap<Long, Dragon>\n");
        builder.append("size : " + StorageManager.getDragons().size() + "\n");

        commandLine.servAnswer = builder.toString();
        commandLine.serverWaitForAnswer = false;
        System.out.printf("command '%s' executed\n", commandLine.command);
        return commandLine;
    }
}





//        StringBuilder builder = new StringBuilder("");
//        var dragons = StorageManager.getDragons();
//
//        builder.append("type : " + dragons.toString() + "\nsize : " + dragons.size() + "\n");
//        for (var pair : dragons.entrySet()){
//            long id = pair.getKey();
//            Dragon dragon = pair.getValue();
//            builder.append(dragon.getName() + "initialized" + " : " + dragon.getCreationDate());
//        }
//        commandLine.servAnswer = builder.toString();
//        commandLine.needArgs = false;
//        commandLine.serverWaitForAnswer = false;
//        return commandLine;