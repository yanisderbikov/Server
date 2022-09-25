package com.company.server;


import com.company.drag.Dragon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 	•	Для хранения необходимо использовать коллекцию типа
 * 	                                java.util.LinkedHashMap
 */

// TODO: 14.09.2022 Операции обработки объектов коллекции должны быть реализованы
//                  с помощью Stream API с использованием лямбда-выражений.

// TODO: 14.09.2022 Объекты в коллекции, передаваемой клиенту,
//                  должны быть отсортированы по имени

public class StorageManager {
    // По-моему должен записывать и выписывать объекты в xml
    public StorageManager(){

    }
    static LinkedHashMap<Long, Dragon> dragonMap = new LinkedHashMap<>();

    public synchronized static Dragon getDragon(long id) {
        return StorageManager.dragonMap.get(id);
    }

    static synchronized void sortDragons(){
        dragonMap = dragonMap.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e1.getKey() , e2.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1,e2)->e1, LinkedHashMap::new));
    }

    public synchronized static void putDragon(long id, Dragon dragon) {
        dragonMap.put(id, dragon);
        sortDragons();
    }

    public static synchronized LinkedHashMap<Long, Dragon> getDragons(){
        return dragonMap;
    }

    public static synchronized void deliteDragon(long key){
        dragonMap.remove(key);
        sortDragons();
    }

    public static synchronized boolean check(long key){
        return dragonMap.containsKey(key);
    }

    public static synchronized void updateMap(LinkedHashMap<Long,Dragon> dragons){
        dragonMap = dragons;
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
