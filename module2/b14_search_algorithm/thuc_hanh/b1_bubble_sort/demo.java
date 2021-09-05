package b14_search_algorithm.thuc_hanh.b1_bubble_sort;

import java.util.Arrays;

public class demo {
    public static void main(String[] args) {
        int[] list={1,2,3,4,5,0};
        int min=0;
        for(int i=0;i<list.length;i++){
            if(list[min]>list[i]){
                min=i;
            }
        }
        int temp=list[0];
        list[0]=list[min];
        list[min]=temp;
        System.out.println(Arrays.toString(list));
    }
}
