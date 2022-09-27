package com.company.data;


import com.company.commandServer.SaveCommand;
import com.company.drag.Dragon;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 	•	Для хранения необходимо использовать коллекцию типа
 * 	                                java.util.LinkedHashMap
 */


// TODO: 14.09.2022 Объекты в коллекции, передаваемой клиенту,
//                  должны быть отсортированы по имени

public class StorageManager {
    // По-моему должен записывать и выписывать объекты в xml
    public StorageManager(){

    }
    SaveCommand saveCommand = new SaveCommand();
    static LinkedHashMap<Long, Dragon> dragonMap = new LinkedHashMap<>();

    public synchronized static Dragon getDragon(long id) {
        return StorageManager.dragonMap.get(id);
    }

    static synchronized void sortDragons(){
        dragonMap = dragonMap.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e1.getKey() , e2.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1,e2)->e1, LinkedHashMap::new));
        save();
    }

    public synchronized static void putDragon(long id, Dragon dragon) {
        dragonMap.put(id, dragon);
        sortDragons();
    }

    public static synchronized LinkedHashMap<Long, Dragon> getDragons(){
        return dragonMap;
    }

    public static synchronized void deleteDragon(long key){
        dragonMap.remove(key);
        save();
    }

    public static synchronized boolean check(long key){
        return dragonMap.containsKey(key);
    }

    public static synchronized void updateMap(LinkedHashMap<Long,Dragon> dragons){
        dragonMap = dragons;
    }

    public static synchronized void save(){
        Dragons dragons = new Dragons();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Dragons.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(dragons, new File("save.xml"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder("");
        for (Dragon dragon : dragonMap.values()){
            builder.append(dragon.toString() + "\n");
        }
        return builder.toString();
    }

}
