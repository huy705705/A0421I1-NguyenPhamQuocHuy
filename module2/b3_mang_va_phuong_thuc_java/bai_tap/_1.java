package b3_mang_va_phuong_thuc_java.bai_tap;
import java.util.Scanner;
public class _1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[]arr={1,2,3,4,5,6,7,8,9};
        System.out.println("Nhap phan tu can xoa: ");
        int number=scanner.nextInt();
        int findedIndex=-1;
        for(int i=0;i<arr.length;i++){
            if(number==arr[i]){
                findedIndex=i;

            }
        }
        if(findedIndex!=-1){
            System.out.println(findedIndex);
            for(int i=findedIndex;i<arr.length-1;i++){
                arr[i]=arr[i+1];
            }
            for(int i=0;i<arr.length-1;i++){
                System.out.println("Mang moi la: "+ arr[i]);
            }
        }else {
            System.out.println("khong tim thay");
        }

    }
}
