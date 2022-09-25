package com.company.drag;

import javax.xml.bind.annotation.*;
import java.time.LocalDateTime;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Dragon {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    // TODO: 24.09.2022 попробовать сделать обертку, и переопределить метод.
    //  Чтоб можно было его использовать.
    private String creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer age; //Значение поля должно быть больше 0, Поле не может быть null
    private Color color; //Поле не может быть null
    private DragonType type; //Поле может быть null
    private DragonCharacter character; //Поле может быть null
    private DragonCave cave; //Поле может быть null



//  getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
    public LocalDateTime getCreationDate() {
        return LocalDateTime.parse(creationDate);
    }

    public Integer getAge() {
        return age;
    }

    public Color getColor() {
        return color;
    }

    public DragonType getType() {
        return type;
    }

    public DragonCharacter getCharacter() {
        return character;
    }

    public DragonCave getCave() {
        return cave;
    }

//    setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDateTime cd) {
        this.creationDate = cd.toString();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setType(DragonType type) {
        this.type = type;
    }

    public void setCharacter(DragonCharacter character) {
        this.character = character;
    }

    public void setCave(DragonCave cave) {
        this.cave = cave;
    }

    //    todo Объект toString нужно отправлять

    @Override
    public String toString() {
        return "Dragon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates.toString() +
                ", creationDate=" + creationDate +
                ", age=" + age +
                ", color=" + color +
                ", type=" + type +
                ", character=" + character +
                ", cave=" + cave.toString() +
                '}';
    }
}
