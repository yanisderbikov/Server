package com.company.drag;

import java.util.ArrayList;

public class ID {
    private static ArrayList<Long> idList = new ArrayList<>();

    public static synchronized long generateID(){
        long id = Double.doubleToLongBits(Math.random());
        if (idList.contains(id)){
            generateID();
        }
        idList.add(id);
        return id;
    }
}
