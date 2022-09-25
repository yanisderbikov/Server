package com.company.drag;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Coordinates {
    private int x;
    private Float y; //Максимальное значение поля: 458, Поле не может быть null

    public Coordinates() {
    }

    public Coordinates(String x, String y) {
        this.x = Integer.parseInt(x);
        this.y = Float.parseFloat(y);
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
