package b1_introduction_java.thuc_hanh;
import java.util.Scanner;
public class _4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Cho pt bac 1 ax+b=0");
        System.out.println("Nhap a: ");
        float a= scanner.nextFloat();
        System.out.println("Nhap b: ");
        float b= scanner.nextFloat();
        if(a==0){
            System.out.println("PT vo nghiem");
        }else {
            System.out.println("Nghiem cua pt la: "+(-b/a));
        }
    }
}
