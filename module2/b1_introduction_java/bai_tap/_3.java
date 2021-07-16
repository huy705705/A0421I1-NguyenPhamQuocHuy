package b1_introduction_java.bai_tap;
import  java.util.Scanner;
public class _3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap USD: ");
        double money=scanner.nextDouble();
        double moneyExchang=money*23000;
        System.out.print("Tien da duoc doi sang VND: "+moneyExchang);
    }
}
