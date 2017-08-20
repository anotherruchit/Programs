package Arrays;

/**
 * Created by ruchitmehta on 8/13/17.
 * https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/
 */
public class RotatedSortedArray {
    public static void main(String args[]){
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));
    }

    public static int search(int[] A, int target){
        int low = 0;
        int high = A.length-1;

        while(low < high){
            int mid = (high + low) / 2;
            if(A[mid] == target)
                return mid;

            // Meaning first half of the array is sorted
            // eg: [4 5 6 7 0 1 2], mid = 7, low = 0, high = 2
            if(A[low] <= A[mid]){
                if(target >= A[low] && target < A[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // second half of the array is sorted
                if(target > A[mid] && target <= A[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return A[low] == target ? low : -1;
    }
}
