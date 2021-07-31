package b3_mang_va_phuong_thuc_java.bai_tap;
import java.util.Scanner;
public class  FindMin5 {
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
        int min=0;
        for (int i=0;i<size1;i++){
            if(arr1[min]>arr1[i]){
                min=i;
            }
        }
        System.out.println("Phan tu nho nhat la: "+arr1[min]+" o vi tri: "+arr1[min]);
    }
}
