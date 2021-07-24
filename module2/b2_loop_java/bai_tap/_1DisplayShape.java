package b2_loop_java.bai_tap;
import java.util.Scanner;
public class _1DisplayShape {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap chieu dai");
        double width=scanner.nextDouble();
        System.out.println("Nhap chieu cao");
        double height=scanner.nextDouble();
        System.out.println("Hinh chu nhat:");
        for (int i=0;i<width;i++){
            String result="";
            for (int j=0;j<height;j++){
                result+=0;
            }
            System.out.println(result);
        }
        System.out.println("Hinh tam giac 1: ");
        for (int i=0;i<5;i++){
            String result="0";
            for (int j=0;j<i;j++){
                result+="0";
            }
            System.out.println(result);
        }
        System.out.println("Hinh tam giac 2: ");

        for (int i=4;i>=0;i--){
            String result="";
            for (int j=i;j>=0;j--){
                result+="0";
            }
            System.out.println(result);
        }
    }
}
