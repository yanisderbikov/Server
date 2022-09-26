package com.company.commandServer;

import com.company.data.StorageClients;
import com.company.utily.CommandLine;

import java.util.HashMap;

public class CheckLoginCommand implements Command {
    @Override
    public CommandLine execute(CommandLine commandLine) {

//        должен вызвать storageClients и там проверить из mxl
//        существует ли такой логин и пароль?

        HashMap<String,String> clientDB = StorageClients.getClientDB();

        String login = commandLine.clientName;
        String password = commandLine.args.get(0);
        boolean isAccepted = false;

        for (var pair : clientDB.entrySet()){
            if (pair.getKey().equals(login)){
                if (pair.getValue().equals(password)){
                    isAccepted = true;
                }
            }
        }

        if (isAccepted){
            commandLine.servAnswer = "Y";
        } else {
            commandLine.servAnswer = "N";
        }
        return commandLine;
    }
}
