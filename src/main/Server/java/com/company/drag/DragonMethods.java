package com.company.drag;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class DragonMethods {




//    Dragon dragon = new Dragon(2L,"hui", )





    void readFile(){
        String fileName = "File.txt";
        FileReader fileReader;
        Scanner scanner = new Scanner(System.in);
        Scanner scannerFile;
        ArrayList<String> arrayListOfFile = new ArrayList<>();

//        if (scanner.hasNextLine()){
//            fileName = scanner.nextLine();
//        }
        try {
            fileReader = new FileReader(fileName);
            scannerFile = new Scanner(fileReader);

            while (scannerFile.hasNextLine()){
                arrayListOfFile.add(scannerFile.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("файл не существует");
        }
    }
}
