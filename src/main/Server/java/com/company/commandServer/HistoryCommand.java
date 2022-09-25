package com.company.commandServer;


import com.company.utily.CommandLine;

import java.util.List;

/**
 * 	•	history: вывести последние 6 команд (без их аргументов)
 */

public class HistoryCommand implements Command {
    List<String> historyList;
    public HistoryCommand(List<String> historyList) {
        this.historyList = historyList;
    }

    public CommandLine execute(CommandLine commandLine){
        System.out.println("выполняется метод history");
        StringBuilder builder = new StringBuilder("");
        for (String str : historyList) {
            builder.append(str+"\n");
        }
        if (historyList.size() == 0){
            builder.append("History is empty");
        }

        commandLine.serverWaitForAnswer = false;
        commandLine.servAnswer = builder.toString();
        return commandLine;
    }
}