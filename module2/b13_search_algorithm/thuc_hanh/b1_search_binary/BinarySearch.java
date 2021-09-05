package b13_search_algorithm.thuc_hanh.b1_search_binary;

public class BinarySearch {
    static int[] list={1,2,3,4,5,6,7,8,9};
    static int binarySearch(int []list,int key){
        int right=list.length-1;
        int left=0;
        int mid=(left+right)/2;
        int result = -1;
        while (left<=right){
            if(key==list[mid]){
                result=mid;
                return result;
            }else if(key<list[mid]){
                right=mid-1;
                mid=(left+right)/2;
            }else {
                left=mid+1;
                mid=(left+right)/2;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(list,0));

    }
}
