package com.company.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Clients {
    private HashMap<String, String> clientDB = new HashMap<>();

    public HashMap<String, String> getClientDB() {
        return clientDB;
    }

    public void setClientDB(HashMap<String, String> clientDB) {
        this.clientDB = clientDB;
    }
}
