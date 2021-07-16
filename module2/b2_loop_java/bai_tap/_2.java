package b2_loop_java.bai_tap;

import java.util.Scanner;

public class _2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] arr= new int[21];
        int count=0;

        for(int i=1;count<21;i++){
            if(i<2){

                arr[count]=i;
                count++;
//                System.out.println("khong phai so NT");
            }else {
                boolean flag=true;
                for(float j=2;j<=Math.sqrt(i);j++){
                    if(i%j ==0){
                        flag=false;
                    }
                }
                if(flag){
//                    System.out.println("La so NT");

                    arr[count]=i;
                    count++;
                }else {
//                    System.out.println("khong phai SNT");
                }
            }
        }
        for (int i=0;i<20;i++) {
            System.out.println(arr[i]);
        }
    }
}
