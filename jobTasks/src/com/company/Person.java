package com.company;

public class Person {
    public String name;
    public int age;

    public Person(String str) {
        int indexSpace = str.indexOf(' ');
        String age = str.substring(indexSpace + 1, str.length());
        String name = str.substring(0, indexSpace);
        this.age = Integer.parseInt(age);
        this.name = name;
    }

}

