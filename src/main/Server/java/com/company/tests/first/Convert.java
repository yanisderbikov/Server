package com.company.tests.first;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.StringWriter;

public class Convert {
    public Convert() throws JAXBException {
    }
    void execute() throws JAXBException, FileNotFoundException {
        Cat cat = new Cat();

        cat.age = 8;
        cat.name = "Bob";

        StringWriter writer = new StringWriter();

        JAXBContext jaxbContext = JAXBContext.newInstance(Cat.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

//        FileOutputStream fileOutputStream = new FileOutputStream(Path.of("/Users/yanderbikovmail.ru/Documents/ProjectsIDE/Maven/projectWithMaven/src/main/Server/java/com/company/data/cat.xml").toFile());
        marshaller.marshal(cat, writer);

        System.out.println(writer.toString());



    }
}