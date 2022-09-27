package com.company.tests.createrPasswords;

import com.company.data.Clients;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.HashMap;

public class CreatePasswords {

    public static void main(String[] args) throws JAXBException {

        HashMap<String, String> namesPasswords = new HashMap<>();
        namesPasswords.put("Yan", "3445");
        namesPasswords.put("Alex", "reggae12345");
        namesPasswords.put("Guest", "0");
        namesPasswords.put("Nikita", "3445");


        Clients clients = new Clients();
        clients.setClientDB(namesPasswords);



        JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(clients, new File("clientsLogins.xml"));




    }


}
