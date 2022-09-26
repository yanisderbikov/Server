package com.company.data;


import com.company.data.StorageManager;
import com.company.drag.Dragon;

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

    public LinkedHashMap<Long, Dragon> getDragonMap() {
        return dragonMap;
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
