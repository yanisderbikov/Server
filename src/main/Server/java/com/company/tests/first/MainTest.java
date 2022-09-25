package com.company.tests.first;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MainTest {
    public static void main(String[] args) throws FileNotFoundException {
        class JaxbWorker {

            public static void main(String[] args) throws IOException {
                // определяем название файла, куда будем сохранять
                String fileName = "/Users/yanderbikovmail.ru/Documents/ProjectsIDE/Maven/projectWithMaven/src/main/Server/java/com/company/tests/example.xml";

                //создаем объект Student с какими-то данными
                Student student = new Student();
                student.setId(1);
                student.setAge(21);
                student.setName("Andrew");
                student.setLanguage("Java");
                student.setPassword("simplepassword");

                // сохраняем объект в XML файл
                convertObjectToXml(student, fileName);

//                // восстанавливаем объект из XML файла
//                Student unmarshStudent = fromXmlToObject(fileName);
//                if (unmarshStudent != null) {
//                    System.out.println(unmarshStudent.toString());
//                }
//
                XmlWriter xmlWriter = new XmlWriter();
                xmlWriter.execute(fileName);

                WriterStack writerStack = new WriterStack();
                writerStack.execute();


            }

            // восстанавливаем объект из XML файла
            private static Student fromXmlToObject(String filePath) {
                try {
                    // создаем объект JAXBContext - точку входа для JAXB
                    JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
                    Unmarshaller un = jaxbContext.createUnmarshaller();

                    return (Student) un.unmarshal(new File(filePath));
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
                return null;
            }

            // сохраняем объект в XML файл
            private static void convertObjectToXml(Student student, String filePath) {
                try {
                    JAXBContext context = JAXBContext.newInstance(Student.class);
                    Marshaller marshaller = context.createMarshaller();
                    // устанавливаем флаг для читабельного вывода XML в JAXB
                    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                    // маршаллинг объекта в файл
                    marshaller.marshal(student, new File(filePath));
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
