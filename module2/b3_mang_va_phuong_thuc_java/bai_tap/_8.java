package b3_mang_va_phuong_thuc_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class _8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "testString";
        char[] charArray = str.toCharArray();
        String findedChar = scanner.next();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println("ki tu: " + charArray[i]);

        }

    }
}
