package com.company.tests.first;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriterStack {
    public void execute() {


        try (BufferedWriter scribe = Files.newBufferedWriter(
                Paths.get("/Users/yanderbikovmail.ru/Desktop/hello.txt"), Charset.defaultCharset())) {
            scribe.write("Hello! Is it me you're looking for?");
        } catch (IOException e) {
            System.err.println("shit happened");
            throw new RuntimeException(e);
        }
    }
}
