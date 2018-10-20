package com.company;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
        String fileName = "dictionary.txt";
        DictionaryEmployee dictionary = new DictionaryEmployee("wszib.com");

        dictionary.SetDictionary(ReadFileDictionary(fileName));

        AddNewEmployes(dictionary);

        WriteFileDictionary(dictionary.GetDictionary(), fileName);
    }

    private static Hashtable<String,Employee> ReadFileDictionary(String fileName){
        Path path = Paths.get(fileName);
        Gson json = new Gson();

        Hashtable<String,Employee> dictionary = new Hashtable<>();
        try {
            List<String> x = Files.readAllLines(path);
            dictionary = json.fromJson(x.get(0), dictionary.getClass());
        } catch (IOException e) {

        }
        return dictionary;
    }

    private static void AddNewEmployes(DictionaryEmployee dictionary ){
        Scanner scanInput = new Scanner(System.in);
        boolean finished = false;
        while (!finished){

            System.out.println("poday imie:");
            String name= scanInput.nextLine();


            System.out.println("podan nazwisko:");
            String surname= scanInput.nextLine();

            dictionary.AddNewEmployee(name, surname);

            System.out.println("Czy wprowadzać dalej: Y / N");
            String exit = scanInput.nextLine().toLowerCase();

            if (Objects.equals(exit, "y")){
                finished = true;
            }
        }

        scanInput.close();
    }
    private static void WriteFileDictionary (Hashtable<String,Employee> dictionary, String fileName){
        Path path = Paths.get(fileName);
        Gson json = new Gson();

        String stringJson = json.toJson(dictionary);

        try {
            Charset utf8 = StandardCharsets.UTF_8;
            Files.write(path, Collections.singleton(stringJson), utf8 );
        }catch (IOException e) {

        }
    }
}
