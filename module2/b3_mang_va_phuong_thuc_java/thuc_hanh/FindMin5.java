package b3_mang_va_phuong_thuc_java.thuc_hanh;
import java.util.Scanner;
public class  FindMin5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] arr=new int [20];
        int size;
        do{
            System.out.println("Nhap so luong phan tu: ");
            size=scanner.nextInt();
            if(size>20){
                System.out.println("Mang phai nho hon 21 phan tu , moi nhap lai ");
            }
        }while (size>20);
        for(int i=0;i<size;i++){
            arr[i]=scanner.nextInt();
        }
        for(int i=0;i<size;i++){
            System.out.println(arr[i]);
        }
        System.out.println("Gia tri nho nhat la: "+arr[findMin(arr,size)]);
    }
    public static int findMin(int []arr,int size){
        int min=arr[0];
        int minIndex=0;
        for (int i=0;i<size;i++){
            if(min>arr[i]){
                min=arr[i];
                minIndex=i;
            }
        }
        return minIndex;
    }
}
