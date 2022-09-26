package com.company.server;

import com.company.commandServer.*;
import com.company.drag.CreatDragon;
import com.company.utily.CommandLine;

import java.util.*;

public class ServerManager {

    CommandLine CL;

    public CommandLine runCommand(CommandLine commandLine){
        this.CL = commandLine;
        Command command = commandMap.get(commandLine.command);
        commandLine = command.execute(commandLine);

        System.out.println("Эта хуита сработала!!!");
        addCommandToHistory(commandLine.command);
        return commandLine;
    }

    private static final Map<String, Command> commandMap = new HashMap<>();
    ArrayList<Object> collection = new ArrayList<>();
    private final List<String> history = new ArrayList<>();

    public ServerManager(){
        LoadCommand load = new LoadCommand();
        load.loadSaves();

        // TODO: 14.09.2022 Докидать оставшиеся команды;
        //  Те кто взаимодействет с объектами должны  быть реализованы с stream API
        commandMap.put("help", new HelpCommand(this));
        commandMap.put("clear", new ClearCommand());
        commandMap.put("show", new ShowCommand());
        commandMap.put("execute_script",
                new ExecuteScriptFileNameCommand(this));
        commandMap.put("history", new HistoryCommand(history));
        commandMap.put("create", new CreatDragon());
        commandMap.put("info", new InfoCommand());
        commandMap.put("insert", new InsertNullCommand()); // вроде сделано
//        commandMap.put("remove_greater_key", new RemoveGreaterKeyNullCommand());
        commandMap.put("remove_key", new RemoveKeyNullCommand());
        commandMap.put("save", new SaveCommand());
        commandMap.put("remove_lower", new RemoveLowerCommand());
        commandMap.put("check_login", new CheckLoginCommand());

        // TODO: 14.09.2022
        //  update id {element}
        //


    }

    void addCommandToHistory(String command){
        if (!CL.serverWaitForAnswer)
            history.add(command);
        while (history.size() > 6)
            history.remove(0);
    }

    public Set<String> getKeysSetCommand(){
        return commandMap.keySet();
    }
}
