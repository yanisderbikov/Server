package com.company.tests.second;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.File;

class DukeTest {
    public static void main(String[] args) throws JAXBException {
        Duke dukeTest = new Duke();
        dukeTest.setAge(2);
        dukeTest.setLang("java");
        JAXBContext jaxbContext = JAXBContext.newInstance(Duke.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(dukeTest, new File("duke.xml"));







    }
}