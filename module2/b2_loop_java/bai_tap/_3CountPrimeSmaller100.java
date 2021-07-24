package b2_loop_java.bai_tap;

import java.util.Scanner;

public class _3CountPrimeSmaller100 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        for(int i=1;i<100;i++){
            if(i<2){
                System.out.println("So nguyen to la: "+i);
            }else {
                boolean flag=true;
                for(float j=2;j<=Math.sqrt(i);j++){
                    if(i%j ==0){
                        flag=false;
                    }
                }
                if(flag){

                    System.out.println("So nguyen to la: "+i);

                }
            }
        }

    }
}
