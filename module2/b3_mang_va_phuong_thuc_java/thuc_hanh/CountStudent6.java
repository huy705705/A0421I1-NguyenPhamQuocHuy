package b3_mang_va_phuong_thuc_java.thuc_hanh;

import java.util.Scanner;

public class  CountStudent6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double []arr1;
        int size1;
        do{
            System.out.println("Nhap so luong phan tu 1: ");
            size1=scanner.nextInt();
            if(size1>30){
                System.out.println("Mang phai nho hon 31 phan tu , moi nhap lai ");
            }
        }while(size1>30);
        arr1=new double[size1];
        for(int i=0;i<size1;i++){
            arr1[i]=scanner.nextInt();
        }
        for(int i=0;i<size1;i++){
            System.out.println("Mang moi la: "+arr1[i]);
        }
        int count=0;
        for(int i=0;i<size1;i++){
            if(arr1[i]>5.0){
                count++;
            }
        }
        System.out.println("So sinh vien dau la: "+count);
    }
}
