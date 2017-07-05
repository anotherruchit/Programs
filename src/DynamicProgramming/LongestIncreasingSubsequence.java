package DynamicProgramming;

/**
 * Created by dharabavishi on 7/1/17.
 * https://leetcode.com/articles/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
    public static void main(String args[])
    {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println("Length of lis is " + longestSubsequence( arr, n ));
    }

    /* time complexity of the above Dynamic Programming (DP) solution is O(n^2) */
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

}
