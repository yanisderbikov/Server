package com.company.data;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.HashMap;


public class StorageClients {
    private static HashMap<String, String> clientDB = new HashMap<>();

    public StorageClients() {
        init();
    }

    public static HashMap<String, String> getClientDB() {
        init();
        return clientDB;
    }

    static void init(){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Clients clients = (Clients)
                    unmarshaller.unmarshal(new File("clientsLogins.xml"));
            StorageClients.clientDB = clients.getClientDB();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
