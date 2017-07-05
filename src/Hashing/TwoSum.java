package Hashing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dharabavishi on 6/15/17.
 * https://www.interviewbit.com/problems/2-sum/
 */
public class TwoSum {

    public static void main(String args[]){
        int[] num = {2, 3, 6, 7, 11, 15};
        int[] result = twoSum(num, 9);
        for(int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }

    public static int[] twoSum(int[] numbers, int target){

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
