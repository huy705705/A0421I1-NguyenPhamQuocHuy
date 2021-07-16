package b1_introduction_java.thuc_hanh;
import java.util.Scanner;
public class _6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nam can tim: ");
        int year=scanner.nextInt();
        if(year%400==0){
            System.out.println("Nam nhuan");
        }else if(year%4==0&&year%100!=0){
            System.out.println("Nam nhuan");
        }else {
            System.out.println("Nam khong nhuan");
        }
    }
}
