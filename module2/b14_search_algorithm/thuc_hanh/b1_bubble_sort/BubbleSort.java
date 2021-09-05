package b14_search_algorithm.thuc_hanh.b1_bubble_sort;

public class BubbleSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void bubbleSort(int[] list) {
        for (int k = 0; k < list.length - 1; k++) {
            for (int i = 0; i < list.length - 1 - k; i++) {
                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        bubbleSort(list);
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }

    }
}

