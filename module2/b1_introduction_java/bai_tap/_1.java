package b1_introduction_java.bai_tap;
import java.util.Scanner;

public class _1 {
    public static void main(String[] args) {
        System.out.println("Enter your name: ");
        Scanner scanner= new Scanner(System.in);
        String name=scanner.nextLine();
        System.out.println("Your name is: "+name);
    }
}
