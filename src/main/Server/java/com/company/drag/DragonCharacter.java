package com.company.drag;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public enum DragonCharacter {
    WISE,
    EVIL,
    CHAOTIC,
    CHAOTIC_EVIL,
    FICKLE
}
