package com.company.commandServer;

import com.company.utily.CommandLine;

public class UpdateIdCommand implements Command {
    public CommandLine execute(CommandLine commandLine){
        System.out.println("выполняется метод updateId");
        System.out.printf("command '%s' executed\n",commandLine.command );
        return null;
    }
}
