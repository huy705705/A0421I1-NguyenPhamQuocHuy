package b3_mang_va_phuong_thuc_java.bai_tap;
import java.util.Scanner;
public class  FindMax4 {
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
                System.out.println("Mang moi la: "+arr[i][j]);
            }
        }
        int maxSize1=0;
        int maxSize2=0;
        for(int i=0;i<size1;i++){
            for (int j=0;j<size2;j++){
                if(arr[maxSize1][maxSize2]<arr[i][j]){
                    maxSize1=i;
                    maxSize2=j;
                }
            }
        }
        System.out.println("Phan tu lon nhat o vi tri: arr["+maxSize1+"]["+maxSize2+"] co gia tri la: "+arr[maxSize1][maxSize2]);
    }
}
