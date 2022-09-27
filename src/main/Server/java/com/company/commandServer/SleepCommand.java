package com.company.commandServer;

import com.company.utily.CommandLine;

public class SleepCommand implements Command{
    @Override
    public CommandLine execute(CommandLine commandLine) {
        int time = 0;
        try{
            time = Integer.parseInt(commandLine.args.get(0));
            Thread.sleep(time);
        }catch (Exception e){
            commandLine.servAnswer = "this is not int";
        }
        commandLine.serverWaitForAnswer = false;
        commandLine.servAnswer = "Command sleep was executing " + time + " milliseconds";
        return commandLine;
    }
}
