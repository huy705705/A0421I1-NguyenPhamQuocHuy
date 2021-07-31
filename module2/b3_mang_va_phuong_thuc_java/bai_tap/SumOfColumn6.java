package b3_mang_va_phuong_thuc_java.bai_tap;
import java.util.Scanner;

public class  SumOfColumn6 {
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
        int size2;
        do{
            System.out.println("Nhap so hang doc: ");
            size2=scanner.nextInt();
            if(size2>10){
                System.out.println("Hang doc phai nho hon 11 phan tu , moi nhap lai ");
            }
        }while(size2>10);
        int [][] arr=new int[size1][size2];
        for(int i=0;i<size1;i++){
            for (int j=0;j<size2;j++){
                arr[i][j]=scanner.nextInt();
            }
        }
        for(int i=0;i<size1;i++){
            for (int j=0;j<size2;j++){
                System.out.println("Mang moi ["+i+"]["+j+"] la: "+arr[i][j]);
            }
        }
        System.out.println("Nhap vi tri cot ban muon tinh tong: ");
        int column=scanner.nextInt();
        int columnSum=0;
        for (int i=0;i<size1;i++){
            columnSum += arr[i][column];
        }
        System.out.println("Tong can tim la: "+columnSum);
    }
}
