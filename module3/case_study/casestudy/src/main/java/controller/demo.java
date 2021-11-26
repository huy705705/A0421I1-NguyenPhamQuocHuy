package controller;

import java.util.regex.Pattern;

public class demo {
    public static void main(String[] args) {
        System.out.println("1");
        System.out.println(Pattern.matches("[a-z]{3,20}\\d{1,9}","huuyquoc123456789"));
        System.out.println("2");
        System.out.println(Pattern.matches("[a-z]{3,20}\\d{1,9}@[a-z]{3,5}\\.[a-z]{3,5}","huuyquoc123456789@gmail.com"));
        System.out.println("3");
        System.out.println(Pattern.matches("090[0-9]{7}|091[0-9]{7}","0912534350"));
    }
}
