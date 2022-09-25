package com.company.drag;


import com.company.server.StorageManager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedHashMap;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Dragons {

    private LinkedHashMap<Long, Dragon> dragonMap;

    public Dragons(){
        this.dragonMap = StorageManager.getDragons();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("");
        for (Dragon dragon : dragonMap.values()){
            builder.append(dragon.toString()+ "\n");
        }
        return builder.toString();
    }

}
