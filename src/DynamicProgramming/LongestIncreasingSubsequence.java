package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ruchitmehta
 * https://leetcode.com/articles/longest-increasing-subsequence/
 * Note : the requirement is subsequence and not subarray. Compare it with
 * http://blog.gainlo.co/index.php/2017/02/02/uber-interview-questions-longest-increasing-subarray/
 * DP - https://www.youtube.com/watch?v=CE2b_-XfVDk
 * Binary Search - https://www.youtube.com/watch?v=S9oUiVYEq7E
 */
public class LongestIncreasingSubsequence {
    public static void main(String args[])
    {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println("Length of lis is " + longestSubsequence( arr, n ));
        System.out.println("Length of lis is (binary search method) " + LIS(arr));

        System.out.println("Length of lis is (binary search method) " + LIS(new int[]{42, 43, 44, 1, 2, 4, 5}));
    }

    /* time complexity of the below Dynamic Programming (DP) solution is O(n^2) */
    public static int longestSubsequence(int[] arr, int n){
        if(arr.length <= 1)
            return 1;

        int lis[] = new int[n];
        int i, j, max = 0;

        // Initialize lis value for all indices
        for(i = 0; i < n; i++){
            lis[i] = 1;
        }

         /* Compute optimized LIS values in bottom up manner */
        for(i = 1; i < n; i++){
            for (j = 0; j < i; j++){
                if(arr[i] > arr[j] && lis[i] < lis[j] + 1){
                    lis[i] = lis[j] + 1;
                }
            }
        }
         /* Pick maximum of all LIS values */
        for(i = 0; i < n; i++){
            if(max < lis[i])
                max = lis[i];
        }

        return max;
    }

    /* Binary Search Method - Time Complexity - O( n log(n) ) */
    static int LIS(int[] arr){
        if(arr.length == 0)
            return  0;
        if(arr.length == 1)
            return 1;

        ArrayList<Integer> result = new ArrayList<>();

        for(int num : arr){
            if(result.size() == 0 || num > result.get(result.size()-1))
                result.add(num);
            else {
                // binary search to find the correct place of the current element
                int start = 0, end = result.size() - 1;
                int mid;
                while(start < end){
                    mid = (start + end)/2;
                    if(num > result.get(mid))
                        start = mid + 1;
                    else
                        end = mid;
                }
                result.set(end, num);
            }
        }

        return result.size();

    }


}
