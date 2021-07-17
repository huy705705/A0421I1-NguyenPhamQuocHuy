package b3_mang_va_phuong_thuc_java.thuc_hanh;
import java.util.Scanner;
public class _4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double fahrenheit;
        double celsius;
        int choice;
        do{
            System.out.println("Menu.");
            System.out.println("1. Fahrenheit to celsius");
            System.out.println("2. Celsius to fahrenheit");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice=scanner.nextInt();
            switch (choice){
                case 1:{
                    System.out.println("Enter fahrenheit: ");
                    fahrenheit=scanner.nextDouble();
                    System.out.println("Fahrenheit to celsius: "+fahrenheitToCelsius(fahrenheit));
                    break;
                }
                case 2:{
                    System.out.println("Enter celsius:");
                    celsius=scanner.nextDouble();
                    System.out.println("Celsius to fahrenheit: "+celsiusToFahrenheit(celsius));
                    break;
                }
                case 0:
                    System.exit(0);
            }
        }while (choice!=0);
    }
    public static double celsiusToFahrenheit(double celsius){
        double fahrenheit=(9.0/5)*celsius+32;
        return fahrenheit;
    }
    public static double fahrenheitToCelsius(double fahrenheit){
        double celsius=(5.0/9)*(fahrenheit-32);
        return celsius;
    }
}
