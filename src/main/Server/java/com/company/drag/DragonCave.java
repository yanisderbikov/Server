package com.company.drag;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DragonCave {
    private long numberOfTreasures; //Значение поля должно быть больше 0

    public DragonCave() {
    }

    public DragonCave(long numberOfTreasures) {
        this.numberOfTreasures = numberOfTreasures;
    }

    public long getNumberOfTreasures() {
        return numberOfTreasures;
    }

    public void setNumberOfTreasures(long numberOfTreasures) {
        this.numberOfTreasures = numberOfTreasures;
    }

    @Override
    public String toString() {
        return "DragonCave{" +
                "numberOfTreasures=" + numberOfTreasures +
                '}';
    }
}
