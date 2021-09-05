package b14_search_algorithm.thuc_hanh.b3_selection_sort;

public class SelectionSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void selectionSort(int[] list) {
        int min = -1;
        for (int k = 0; k < list.length ; k++) {
            min=k;
            for (int i = 0+k; i < list.length ; i++) {
                if (list[min] > list[i]) {
                    min=i;
                }
            }
            if(min!=k){
                int temp=list[k];
                list[k]=list[min];
                list[min]=temp;
            }

        }
    }

    public static void main(String[] args) {
        selectionSort(list);
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }
    }
}
