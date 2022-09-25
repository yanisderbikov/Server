package com.company.tests.testDragon;

import com.company.drag.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.time.LocalDateTime;

public class TestDragon {
    public static void main(String[] args) throws JAXBException {
        Dragon dragon = new Dragon();
        dragon.setAge(12);
        dragon.setCave(new DragonCave(1232323));
        dragon.setColor(Color.BROWN);
        dragon.setCreationDate(LocalDateTime.now());
        dragon.setCharacter(DragonCharacter.CHAOTIC);
        dragon.setId(ID.generateID());
        dragon.setName("Yan");
        dragon.setType(DragonType.FIRE);
        dragon.setCoordinates(new Coordinates("12", "1"));


        Dragon dragon2 = new Dragon();
        dragon2.setAge(112);
        dragon2.setCave(new DragonCave(1323));
        dragon2.setColor(Color.WHITE);
        dragon2.setCreationDate(LocalDateTime.now());
        dragon2.setCharacter(DragonCharacter.CHAOTIC_EVIL);
        dragon2.setId(ID.generateID());
        dragon2.setName("Alex");
        dragon2.setType(DragonType.AIR);
        dragon2.setCoordinates(new Coordinates("122", "11"));

        DragonsTestClass dragonsTestClass = new DragonsTestClass();
        dragonsTestClass.add(dragon);
        dragonsTestClass.add(dragon2);

//        JAXBContext jaxbContext = JAXBContext.newInstance(Dragons.class);
//        Marshaller marshaller = jaxbContext.createMarshaller();
//        marshaller.marshal(dragons, new File("dragons.xml"));

        JAXBContext jaxbContext = JAXBContext.newInstance(DragonsTestClass.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Object unmarshalled = unmarshaller.unmarshal(new File("dragons.xml"));
        DragonsTestClass dragonsTestClass1 = (DragonsTestClass) unmarshalled;
        System.out.println(dragonsTestClass1.toString());


    }
}
