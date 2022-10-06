package com.company.commandServer;


import com.company.data.StorageManager;
import com.company.drag.Dragon;
import com.company.utily.CommandLine;

public class RemoveKeyNullCommand implements Command {
    public CommandLine execute(CommandLine commandLine){
        System.out.println("Command 'remove key null' is running");

        try {
            long key = Long.parseLong(commandLine.args.get(0));
            StorageManager.getDragons()
                    .entrySet()
                    .stream()
                    .flatMap(k -> k.getKey().describeConstable().stream())
                    .filter(k -> k == key)
                    .filter(k -> StorageManager.getDragons().get(k).getClientName().equals(commandLine.clientName))
                    .forEach(StorageManager::deleteDragon);

            System.out.printf("command '%s' executed\n",commandLine.command );
            commandLine.servAnswer = "command executed";
        } catch (Exception e){
            System.out.printf("command '%s' wasn't executed\n",commandLine.command );
            commandLine.servAnswer = "command wasn't executed";
        }
        commandLine.serverWaitForAnswer = false;
        return commandLine;
//
//
//        try {
//            long key = Long.parseLong(commandLine.args.get(0));
//            if (StorageManager.check(key)){
//                StorageManager.deleteDragon(key);
//            } else {
//                throw new Exception();
//            }
//            // все сработало, на сервере больше не требуется получать данные
//            commandLine.serverWaitForAnswer = false;
//            System.out.printf("command '%s' executed\n",commandLine.command );
//            return commandLine;
//        }catch (Exception e){
//            commandLine.servAnswer = "this is not a long or dragon doesn't exist";
//            commandLine.needArgs = true;
//            return commandLine;
//        }
    }
}