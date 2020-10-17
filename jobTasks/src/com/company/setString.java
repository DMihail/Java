package com.company;
import java.util.*;

public class setString {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите строки");
        List<String> list = new ArrayList();
        setList(list, scan);
    }

    public static void setList(List<String> list, Scanner scan) {
        String end = "конец";
        String str = scan.nextLine();
        if (!end.equals(str)) {
            list.add(str);
            setList(list, scan);
        } else {
            int max = list.get(0).length(), min = list.get(0).length();
            System.out.println("Строки: ");
            for (String n: list ) {
                if (max < n.length()) {
                    max = n.length();
                }
                if (min > n.length()) {
                    min = n.length();
                }
                System.out.println(n);
            }
            System.out.println("Kоличество строк в листе: " +  list.size());
            System.out.println("Количество символов в самой длинной строке: " +  max);
            System.out.println("Kоличество строк в  самой короткой строке самой короткой строке: " +  min);
        }
    }

}
