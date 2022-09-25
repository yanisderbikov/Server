package com.company.commandServer;

import com.company.drag.Dragon;
import com.company.drag.Dragons;
import com.company.server.StorageManager;
import com.company.utily.CommandLine;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.LinkedHashMap;

public class LoadCommand {

    Dragons dragons;
    public void loadSaves(){
        LinkedHashMap<Long, Dragon> dragonMap;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Dragons.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            dragons = (Dragons) unmarshaller.unmarshal(new File("save.xml"));
        } catch (Exception e){
            e.printStackTrace();
        }
        dragonMap = dragons.getDragonMap();
        StorageManager.updateMap(dragonMap);
    }
}
