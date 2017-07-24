package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruchitmehta
 * https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
 * https://www.youtube.com/watch?v=ohHWQf1HDfU&feature=player_embedded
 *
 */
public class MaxSumContiguousSubArray {
    public static void main(String args[]){
        MaxSumContiguousSubArray sub = new MaxSumContiguousSubArray();
        List<Integer> array = new ArrayList<>();
        array.add(-2);
        array.add(-1);
        array.add(0);
        array.add(1);
        array.add(-1);
        array.add(2);
        array.add(3);
        array.add(-2);
        array.add(4);
        System.out.println(sub.maxSubArray(array));
    }

    public int maxSubArray(final List<Integer> a) {

        int maxSoFar = a.get(0);
        int maxCurrently = a.get(0);

        for(int i = 1; i < a.size(); i++){
            maxCurrently = Math.max(maxCurrently + a.get(i), a.get(i));
            maxSoFar = Math.max(maxCurrently, maxSoFar);
        }
        return maxSoFar;
    }
}
