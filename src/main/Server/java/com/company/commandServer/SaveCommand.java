package com.company.commandServer;

import com.company.drag.Dragon;
import com.company.drag.Dragons;
import com.company.server.StorageManager;
import com.company.utily.CommandLine;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.LinkedHashMap;

/**
 * save : сохранить коллекцию в файл
 */

public class SaveCommand implements Command {
    public CommandLine execute(CommandLine commandLine) {
        System.out.println("выполняется метод save");
        try {

            Dragons dragons = new Dragons();

            JAXBContext jaxbContext = JAXBContext.newInstance(Dragons.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(dragons, new File("save.xml"));

            commandLine.serverWaitForAnswer = false;
            commandLine.servAnswer = "Collection was saved to file 'save.xml'";
            System.out.printf("command '%s' executed\n",commandLine.command );
            return commandLine;

        } catch (Exception e) {
            e.printStackTrace();
            commandLine.servAnswer = "Command wasn't execute";
            commandLine.serverWaitForAnswer = false;
            return commandLine;
        }

    }
}
