package com.company.commandServer;

import com.company.utily.CommandLine;

public class StopServerCommand implements Command{
    @Override
    public CommandLine execute(CommandLine commandLine) {
        commandLine.servAnswer = "server stopped";
        commandLine.serverWaitForAnswer = false;
        return commandLine;
    }
}
