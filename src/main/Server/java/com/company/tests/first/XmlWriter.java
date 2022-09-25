package com.company.tests.first;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class XmlWriter {
    public void execute(String fileName) throws IOException {
        fileName = "/Users/yanderbikovmail.ru/Documents/ProjectsIDE/Maven/projectWithMaven/src/main/Server/java/com/company/tests/test";
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        writer.write("<name>Yan</name>");
        writer.flush();
        writer.close();

    }
}
