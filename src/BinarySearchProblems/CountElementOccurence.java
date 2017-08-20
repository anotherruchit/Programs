package BinarySearchProblems;

/**
 * Created by ruchitmehta on 6/21/17.
 * https://www.interviewbit.com/problems/count-element-occurence/
 * Problem Statement: Given a sorted array of integers, find the number of occurrences of a given target value.
 *                  If the target is not found in the array, return 0
 */
public class CountElementOccurence {
    public static void main(String args[]){
        int[] array = {1, 3, 5, 5, 5, 5, 6, 12, 15};
        int firstIndex = countElementOccurence(array, array.length, 5, true);
        int lastIndex = countElementOccurence(array, array.length, 5, false);
        System.out.println("Total number of occurences of the elemnts are: " + (lastIndex - firstIndex + 1));
    }

    public static int countElementOccurence(int[] arr, int length, int x, boolean searchFirst){
        if(arr.length == 0){
            return -1;
        }
        int start = 0, end = length - 1, mid, result = -1;

        while (start <= end){
            mid = (start + end) / 2;
            if(arr[mid] == x){
                result = mid;
                if(searchFirst){
                    end = mid - 1; // go on searching towards the left
                }else{
                    start = mid + 1; // go on searching towards the right
                }
            } else if(x > arr[mid]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }
}
