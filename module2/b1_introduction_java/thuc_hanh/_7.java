package b1_introduction_java.thuc_hanh;
import java.util.Scanner;
public class _7 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhap can nang");
        double weight=scanner.nextDouble();
        System.out.println("nhap chieu cao");
        double height=scanner.nextDouble();
        double BMI=weight/(height*height);
        if(BMI<18.5){
            System.out.println("Underweight");
        }else if(BMI>=18.5&&BMI<25.0){
            System.out.println("Normal");
        }else  if(BMI>=25.0&&BMI<30.0){
            System.out.println("Overweight");
        }else {
            System.out.println("obese");
        }
    }
}
