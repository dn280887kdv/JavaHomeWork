package com.pb.kuptsov.hw9;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class FileNumbers {
    private final static Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) throws IOException {
        FileNumbers fileNumbers = new FileNumbers();
        File file = fileNumbers.createNumbersFile();

        fileNumbers.createOddNumbersFile(file);

        LOGGER.info("Конец программы");
    }

    public File createNumbersFile() throws IOException {
        FileWriter file = new FileWriter("numbers.txt");
        String str = "";
        for (int i = 0; i < 10; i++){
            for (int y = 0; y < 10; y++){
                int rand = new Random().nextInt(101);
                str += rand + " ";
            }
            str += "\n";
        }
        file.write(str);
        file.close();
        File f = new File("numbers.txt");
        LOGGER.info("Создан файл и записан файл " + f.getName());
        return f;
    }

    public void createOddNumbersFile(File oldFile) throws IOException {
        FileReader fileReader = new FileReader(oldFile);
        Scanner scanner = new Scanner(fileReader);
        String str = "";
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            Scanner temp = new Scanner(line);
            while (temp.hasNextInt()){
                int i = temp.nextInt();
                if(i%2 == 0){
                    str += 0 + " ";
                } else str += i + " ";
            }
            str += "\n";
        }

        FileWriter file = new FileWriter("odd-numbers.txt");
        file.write(str);
        System.out.println(str);
        fileReader.close();
        file.close();
        File f = new File("odd-numbers.txt");
        LOGGER.info("Создан файл и записан файл " + f.getName());
    }
}
