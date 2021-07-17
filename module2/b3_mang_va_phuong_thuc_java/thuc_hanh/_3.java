package b3_mang_va_phuong_thuc_java.thuc_hanh;
import java.util.Scanner;
public class _3 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int number;
        int []arr;
        do {
            System.out.println("nhap so phan tu cua mang: ");
            number=scanner.nextInt();
            if(number>20){
                System.out.println("Moi nhap lai, phai nho hon 20!!!");
            }
        } while(number>20) ;
        arr=new int[number];
        for(int i=0;i<number;i++){
            System.out.println("Nhap phan tu thu "+i+":");
            arr[i]=scanner.nextInt();
        }
        for(int i=0;i<number;i++){
            System.out.println("Gia tri la: "+arr[i]);
        }
        int max=arr[0];
        int maxIndex=0;

        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
                maxIndex=i;
            }
        }
        System.out.println("Phan tu lon nhat o vi tri thu "+maxIndex+" co gia tri la: "+max);
    }

}
