package Arrays;

/**
 * Created by ruchitmehta
 *
 * Hackerrank problem
 * Max Subarray
 * TODO: remaining
 */
public class LongestSubArraySum {

    public static void main(String args[]){
        System.out.println(maxLength(new int[]{1, 2, 4, 3, 1, 1, 1,}, 4));
    }

    static int maxLength(int[] a, int k){

        int subArrayLength = 0;
        for(int i = 0; i < a.length; i++){

            subArrayLength = Math.max(maxSubLength(a, i, k, 0), subArrayLength);
        }

        return subArrayLength;
    }

    static int maxSubLength(int[] a, int currPos, int k, int sum){
        if(currPos >= a.length)
            return 0;
        sum = sum + a[currPos];
        if(sum == k){
            return 1;
        } else if(sum < k){
            return 1 + maxSubLength(a, currPos+1, k, sum);
        } else
            return 0;
    }

}
