package Hashing;

import java.lang.reflect.Array;
import java.util.*;

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

        List<Integer> list = Arrays.asList(2,3,5,7,11,15);
        System.out.println(twoSum(list, 13).toString());
        List<Integer> list1 = Arrays.asList(4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8);
        System.out.println(twoSum(list1, -3).toString());
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

    public static ArrayList<Integer> twoSum(List<Integer> list, int sum){
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        if(list.size() == 0 || list == null)
            return result;

        for(int i = 0; i < list.size(); i++){
            int curr = list.get(i);
            if(map.containsKey(sum - curr)){
                result.add(map.get(sum - curr));
                result.add(i);
                return result;
            } else {
                // add to the map
                map.put(curr, i);
            }
        }
        return result;
    }
}
