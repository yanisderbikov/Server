package com.company.commandServer;

import com.company.server.ServerManager;
import com.company.utily.CommandEnum;
import com.company.utily.CommandLine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *  считать и исполнить скрипт из указанного файла.
 *  В скрипте содержатся команды в таком же виде,
 *  в котором их вводит пользователь в интерактивном режиме.
 **/

public class ExecuteScriptFileNameCommand implements Command {
    ServerManager serverManager;
    List<CommandLine> listOfCommand;
    String clientName;

    public ExecuteScriptFileNameCommand(ServerManager serverManager){
        this.serverManager = serverManager;
        listOfCommand = new ArrayList<>();
    }

    @Override
    public CommandLine execute(CommandLine commandLine) {
        System.out.println("выполняется метод execute file name cmd");
        this.clientName = commandLine.clientName;
        if (commandLine.args.size() == 0){
            commandLine.servAnswer = "No inputs";
            commandLine.serverWaitForAnswer = false;
            return commandLine;
        }
        readFile(commandLine.args.get(0));
        executeFile();
        listOfCommand.clear();

        commandLine.serverWaitForAnswer = false;
        commandLine.servAnswer = "Command was executed";
        return commandLine;
    }

    void readFile(String fileName){

        File file = new File(fileName);

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                CommandLine commandLine = new CommandLine();
                commandLine.clientName = clientName;
                String strAtFile = sc.nextLine();
                if (strAtFile.equalsIgnoreCase("create")){
                    commandLine.command = "create";
                    for (int i = 0; i < 8; i++) {
                        try {
                            commandLine.args.add(i, sc.nextLine());
                        }catch (NoSuchElementException e){
                            System.err.println("File incorrect");
                        }
                    }
                }else {
                    commandLine = scan(strAtFile);
                }
//                Делает проверку, чтобы нельзя было запускать файл, который запускает файл
                if (!commandLine.command.equals("execute_script")){
                    listOfCommand.add(commandLine);
                }
            }
        }catch (IOException e){
            System.err.printf("файл по пути \"%s\" не найден\n", fileName);
        }
    }

    void executeFile(){

        for (CommandLine commandLine : listOfCommand){
            commandLine.serverWaitForAnswer = true;
            while (commandLine.serverWaitForAnswer){
                commandLine = serverManager.runCommand(commandLine);
                System.out.println(commandLine.servAnswer);
//                listOfCommand.remove(commandLine);
            }
        }
    }

    CommandLine scan(String line){
        CommandLine commandLine = new CommandLine();
        Scanner buf = new Scanner(line);
        commandLine.command = buf.next();// отправилась первавя слово входящей команды

        while (true) {
            if (!buf.hasNext()) {
                break;
            }
            commandLine.args.add(buf.next());// отправилась вторая слово и сл. входящей комманды
        }
        return commandLine;
    }
}