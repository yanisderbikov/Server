package com.company.commandServer;


import com.company.utily.CommandLine;

public class FilterLessThanViewViewCommand implements Command {
    public CommandLine execute(CommandLine commandLine){
        System.out.println("выполняется метод HelpCommand");
        return null;
    }
}