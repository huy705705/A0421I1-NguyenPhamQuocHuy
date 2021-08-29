package b4_lop_va_doi_tuong_trong_java.bai_tap.b2_stop_watch;

import java.util.Arrays;

public class StopWatchTest {
    public static void main(String[] args) {
        int[] number=new int [1000];
        for (int i=0;i<number.length;i++){
            number[i]=(int)(Math.random()*1000);

        }
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        Arrays.sort(number);
        stopWatch.stop();
        System.out.println("milisecond: "+stopWatch.getElapseTime());
    }
}
