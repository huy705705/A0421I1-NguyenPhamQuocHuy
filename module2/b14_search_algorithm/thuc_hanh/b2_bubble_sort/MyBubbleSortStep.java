package b14_search_algorithm.thuc_hanh.b2_bubble_sort;

import java.util.Arrays;

public class MyBubbleSortStep {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void bubbleSort(int[] list) {
        System.out.println("Begin");
        for (int k = 0; k < list.length - 1; k++) {
            for (int i = 0; i < list.length - 1 - k; i++) {
                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    System.out.printf("Swap %d with %d\n",list[i],list[i+1]);
                }
            }
            System.out.println("List after the "+(k+1)+" sort: "+ Arrays.toString(list));
        }
    }

    public static void main(String[] args) {
        bubbleSort(list);
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }

    }
}
