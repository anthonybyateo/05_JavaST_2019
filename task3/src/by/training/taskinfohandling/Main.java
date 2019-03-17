package by.training.taskinfohandling;

import by.training.taskinfohandling.reader.FileReader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        FileReader reader = new FileReader();
        String str = new String();
        try {
            str = reader.readData("data/lab3-text.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(str);
    }
}
