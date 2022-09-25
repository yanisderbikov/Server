package com.company.tests.testDragon;

import com.company.drag.Dragon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedHashMap;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DragonsTestClass {
    private LinkedHashMap<Long, Dragon> dragons = new LinkedHashMap<>();

    public DragonsTestClass(){}

    public void add(Dragon dragon){
        dragons.put(dragon.getId(),dragon);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("");
        for (Dragon dragon : dragons.values()){
            builder.append(dragon.toString()+ "\n");
        }
        return builder.toString();
    }
}
