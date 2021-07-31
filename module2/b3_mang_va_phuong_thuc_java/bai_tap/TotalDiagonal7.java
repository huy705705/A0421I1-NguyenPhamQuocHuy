package b3_mang_va_phuong_thuc_java.bai_tap;
import java.util.Scanner;

public class  TotalDiagonal7 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int size1;
        do{
            System.out.println("Nhap so hang ngang: ");
            size1=scanner.nextInt();
            if(size1>10){
                System.out.println("Hang ngang phai nho hon 11 phan tu , moi nhap lai ");
            }
        }while(size1>10);
        int [][] arr=new int[size1][size1];
        for(int i=0;i<size1;i++){
            for (int j=0;j<size1;j++){
                arr[i][j]=scanner.nextInt();
            }
        }
        for(int i=0;i<size1;i++){
            for (int j=0;j<size1;j++){
                System.out.println("Mang moi ["+i+"]["+j+"] la: "+arr[i][j]);
            }
        }
        int sum1=0;
        
        for(int i=0;i<size1;i++){
            sum1+=arr[i][i];
        }
        int sum2=0;
        for(int i=0;i<size1;i++){
            sum2+=arr[i][size1-i-1];
        }
        System.out.println("tong sum1: "+sum1);
        System.out.println("tong sum2: "+sum2);

    }
}
