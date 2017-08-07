package Arrays;

/**
 * Created by ruchitmehta
 * http://blog.gainlo.co/index.php/2017/02/02/uber-interview-questions-longest-increasing-subarray/
 * Time Complexity O(n)
 */
public class LongestIncreasingSubarray {

    public static void main(String args[]){
        int[] array = {1, 2, 3, 2, 4, 5, 6};
        System.out.println(longestSubarray(array));
    }

    static int longestSubarray(int[] array){
        if(array.length == 0)
            return 0;
        if(array.length == 1)
            return 1;
        int start = 0, end = 1;
        int longestDistance = 0;

        while(end < array.length){
            if(array[end] > array[end-1]){
                if(end-start+1 > longestDistance)
                    longestDistance = end-start+1;
            } else {
                start = end;
            }
            end++;
        }
        return longestDistance;
    }
}
