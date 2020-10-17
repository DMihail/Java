package com.company;

import java.util.*;
import java.io.*;

public class SumReadFile {

    public static void main(String[] args) {
        List<Integer> list = readFile();
        findMinMaxNumber(list);
    }

    public static List<Integer> readFile() {
        List<Integer> spaceList = new ArrayList();
        List<Integer> numberList = new ArrayList();
        String numbers = null;
        int sum = 0;
        String path = "src/textFiles/numbers.txt";
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                numbers = myReader.nextLine();;
                numbers = numbers + ' ';
                for (int i = 0; i < numbers.length(); i++) {
                    if (numbers.charAt(i) == ' ') {
                        spaceList.add(i);
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (int i = 0; i < spaceList.size(); i++) {
            if (i == 0) {
                String str = numbers.substring(0, spaceList.get(i));
                sum += Integer.parseInt(str);
                numberList.add(Integer.parseInt(str));
            } else
            if (i != spaceList.get(spaceList.size() - 1)) {
                String str = numbers.substring(spaceList.get(i - 1), spaceList.get(i));
                String num = str.substring(1, str.length());
                numberList.add(Integer.parseInt(num));
                sum += Integer.parseInt(num);
            }
        }
        System.out.println("Суммa чисел: " + sum);
        return numberList;
    }

    public static void findMinMaxNumber(List<Integer> list) {
        int max = list.get(0), min = list.get(0);
        for (Integer n: list ) {
            if (max < n) {
                max = n;
            }
            if (min > n) {
                min = n;
            }
        }
        System.out.println("Самое большое число: " + max);
        System.out.println("Самое маленькое число: " + min);
    }

}
