package BinarySearchProblems;

/**
 * Created by ruchitmehta on 6/21/17.
 */
public class BinarySearch {

    public static void main(String args[]){
        int[] array = {1, 3, 5, 12, 23, 45, 67, 88, 90};
        int index = binarySearch(array, array.length, 45);
        System.out.println("Element found at location: " + index);
        index = binarySearch(array, array.length, 33);
        System.out.println("Element found at location: " + index);
    }

    public static int binarySearch(int[] arr, int length, int x){
        if(arr.length == 0)
            return  -1;

        int start = 0, end = length - 1, mid;
        while(start <= end){
            mid = end + (start - end)/2; // https://www.youtube.com/watch?v=OAZc1zwjERU
            if(arr[mid] == x){
                return mid;
            } else if(arr[mid] > x){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
