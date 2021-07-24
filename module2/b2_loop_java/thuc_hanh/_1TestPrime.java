package b2_loop_java.thuc_hanh;
import java.util.Scanner;
public class _1TestPrime {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap so can kiem tra: ");
        float number=scanner.nextFloat();
        if(number<2){
            System.out.println("khong phai so NT");
        }else {
            boolean flag=true;
            for(float i=2;i<=Math.sqrt(number);i++){
                if(number%i ==0){
                    flag=false;
                }
            }
            if(flag){
                System.out.println("La so NT");
            }else {
                System.out.println("khong phai SNT");
            }
        }
    }
}
