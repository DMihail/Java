package com.company;

import java.util.*;
import java.io.*;

public class User {

    public static void main(String[] args) {
        List<String> lineList = new ArrayList<String>();
        List<Person> personList = new ArrayList<Person>();
        getData(lineList);
        for (int i = 0; i < lineList.size(); i++) {
            personList.add(new Person(lineList.get(i)));
        }
        findName(personList);
        sortAge(personList);
    }

    public static void getData(List<String> lineList) {
        String path = "src/textFiles/userData.txt";
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();;
                lineList.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void sortAge(List<Person> personList) {
        List<String> lineList = new ArrayList<String>();
        for (Person n: personList) {
            Person person = n;
            String str = person.age + " " + person.name;
            lineList.add(str);
        }
        System.out.println("Люди в порядке возрастания их возраста: ");
        Collections.sort(lineList);
        for (String n: lineList) {
            System.out.println(n);
        }
    }

    public static void findName(List<Person> personList) {
        Map<String, Integer> names = new HashMap<String, Integer>();
        for (Person n: personList) {
            Person person = n;
            if (names.containsKey(person.name)) {
                int name = names.get(person.name);
                names.put(person.name, name + 1);
            } else {
                names.put(person.name, 1);
            }
        }
        System.out.println("Частота имени в списке: ");
        names.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }

}
