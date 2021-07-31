package b3_mang_va_phuong_thuc_java.bai_tap;
import java.util.Scanner;

public class  MerArrray3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int []arr1;
        int size1;
        do{
            System.out.println("Nhap so luong phan tu 1: ");
            size1=scanner.nextInt();
            if(size1>20){
                System.out.println("Mang phai nho hon 21 phan tu , moi nhap lai ");
            }
        }while(size1>20);
        arr1=new int[size1];
        for(int i=0;i<size1;i++){
            arr1[i]=scanner.nextInt();
        }
        for(int i=0;i<size1;i++){
            System.out.println(arr1[i]);
        }
        int []arr2;
        int size2;
        do{
            System.out.println("Nhap so luong phan tu 2: ");
            size2=scanner.nextInt();
            if(size2>20){
                System.out.println("Mang phai nho hon 21 phan tu , moi nhap lai ");
            }
        }while(size2>20);
        arr2=new int[size2];
        for(int i=0;i<size2;i++){
            arr2[i]=scanner.nextInt();
        }
        for(int i=0;i<size2;i++){
            System.out.println(arr2[i]);
        }
        int size3=size1+size2;
        int[] arr3=new int[size3];
        for(int i=0;i<size1;i++){
            arr3[i]=arr1[i];
        }
        int j=0;
        for (int i=size1;i<size3;i++){
            arr3[i]=arr2[j];
            System.out.println("j: "+j);
            System.out.println("size1: "+size1);
            j++;
        }
        for(int i=0;i<size3;i++){
            System.out.println("Mang moi: "+arr3[i]);
        }
    }

}
