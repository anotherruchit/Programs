package BinarySearchProblems;

/**
 * Created by dharabavishi on 6/21/17.
 * https://www.interviewbit.com/problems/rotated-array/
 * https://www.youtube.com/watch?v=4qjprDkJrjY&feature=player_embedded
 */
public class RotationCount {

    public static void main(String args[]){
        int[] array = {3, 5, 12, 23, 45, 67, 88, 90, 1};
        int [] array1 = {67, 88, 90, 1, 3, 5, 12, 23, 45};
        int index = findRotationCount(array, array.length);
        System.out.println("Element found at location: " + index);
        index = findRotationCount(array1, array.length);
        System.out.println("Element found at location: " + index);
    }

    public static int findRotationCount(int[] arr, int n){
        if(arr.length == 0){
            return -1;
        }
        int start = 0, end = n - 1, mid;

        while(start <= end){

            //case 1 - array is already sorted and the first element is the smallest element itself
            if(arr[start] < arr[end]){
                return start;
            }

            //case 2 - mid element is the smallest element and we compare it with its neighbour
            mid = end + (start - end)/2;
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;
            if(arr[prev] > arr[mid] && arr[next] > arr[mid]){
                return mid;
            }

            //case 3 - smallest element is in the left sub array
            if(arr[mid] <= arr[start]){
                end = mid - 1;
            } //case 3 - smallest element is in the right sub array
            else if(arr[mid] >= arr[end]){
                start = mid + 1;
            }
        }
        return -1;
    }
}
