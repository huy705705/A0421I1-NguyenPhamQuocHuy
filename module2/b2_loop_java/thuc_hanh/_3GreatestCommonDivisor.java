package b2_loop_java.thuc_hanh;
import java.util.Scanner;
public class _3GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhap so a: ");
        int a=scanner.nextInt();
        System.out.println("nhap so b: ");
        int b=scanner.nextInt();
        if(a==0||b==0){
            System.out.println("uoc chung la: "+(a+b));
        }else {
            while (a!=b){
                if(a>b){
                    a-=b;
                }else {
                    b-=a;
                }
            }
            System.out.println("uoc chung la: "+a);
        }
    }
}
