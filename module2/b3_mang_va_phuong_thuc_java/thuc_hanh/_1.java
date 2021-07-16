package b3_mang_va_phuong_thuc_java.thuc_hanh;
import java.util.Scanner;
public class _1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] arr=new int [20];
        int []  arrReverse=new int[20];
        System.out.println("Nhap so phan tu: ");
        int n=scanner.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Nhap phan tu thu " + i);
            arr[i]=scanner.nextInt();
        }
        System.out.println("Mang 1: ");
        for(int i=0;i<n;i++){
            System.out.println("Phan tu thu "+i+" :"+arr[i]);
        }
        for(int i=0;i<n;i++){
            arrReverse[n-1-i]=arr[i];
        }
        System.out.println("Mang 2: ");
        for(int i=0;i<n;i++){
            System.out.println("Phan tu thu "+i+" :"+arrReverse[i]);
        }
    }
}
