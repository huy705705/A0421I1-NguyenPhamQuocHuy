package b3_mang_va_phuong_thuc_java.bai_tap;
import java.util.Scanner;

public class  AddElement2{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int []arr;
        int size;
        do{
            System.out.println("Nhap so luong phan tu: ");
            size=scanner.nextInt();
            if(size>20){
                System.out.println("Mang phai nho hon 21 phan tu , moi nhap lai ");
            }
        }while(size>20);
        arr=new int[size+1];
        for(int i=0;i<size;i++){
            arr[i]=scanner.nextInt();
        }
        for(int i=0;i<size;i++){
            System.out.println(arr[i]);
        }
        System.out.println("Nhap phan tu can them: ");
        int insertValue=scanner.nextInt();
        System.out.println("Nhap vi tri can them: ");
        int insertIndex=scanner.nextInt();

        for(int i=arr.length-1;i>=insertIndex+1;i--){
            arr[i]=arr[i-1];
        }
        arr[insertIndex]=insertValue;

        for(int i=0;i<arr.length;i++){
            System.out.println("Mang moi la: "+arr[i]);
        }
    }

}
