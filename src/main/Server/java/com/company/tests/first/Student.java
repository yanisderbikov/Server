package com.company.tests.first;

import javax.xml.bind.annotation.*;

// определяем корневой элемент
@XmlRootElement(name = "Student")
// определяем последовательность тегов в XML
@XmlType(propOrder = {"name", "age", "language"})
public class Student {
    private int id;
    private String name;
    private int age;
    private String language;

    private String studPassword;

    public Student() {
    }

    public Student(int id, String name, int age, String language) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.language = language;
    }

    // указываем, что id должно быть атрибутом
    @XmlAttribute
    public int getId() {
        return id;
    }

    // указываем, что мы не хотим сохранять пароль в XML
    @XmlTransient
    public String getPassword() {
        return studPassword;
    }

    // указываем, что поле language должно быть представлено в XML как lang
    @XmlElement(name = "lang")
    public String getLanguage() {
        return language;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String studPassword) {
        this.studPassword = studPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", language='" + language + '\'' +
                '}';
    }
}