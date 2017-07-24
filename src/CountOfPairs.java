import sun.text.normalizer.Trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ruchitmehta
 * http://www.geeksforgeeks.org/count-pairs-with-given-sum/
 * Another variation and solution: http://javarevisited.blogspot.com/2014/08/how-to-find-all-pairs-in-array-of-integers-whose-sum-equal-given-number-java.html
 */
public class CountOfPairs {

    private static int countPairsWithSum_ByHashMap(int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        //Find and store frequency of each number in array
        for(int num : arr){
            if(map.containsKey(num)){
                int count = map.get(num);
                map.put(num, count + 1);
            }else{
                map.put(num, 1);
            }
        }

        int pairs = 0;
        for(int num : arr){
            if(map.containsKey(sum - num)){
                pairs += map.get(sum - num);	//counting each pair 2 times

                //Condition for case {1,1,1,1} : 2
                if(sum - num == num){
//                    System.out.println("reducing count for sum: " + sum);
//                    System.out.println("reducing count for num: " + num);
                    pairs--;
                }
            }
        }
        //Divide by 2 as we counted each pair twice
//        System.out.println("Total number of pairs: " + pairs);
        return pairs/2;
    }

    // Driver method to test the above function
    public static void main(String[] args) {

        int sum = 2;
        int arr[] = new int[]{2,6,2,5,6,8,1};
        int arr1[]  = new int[]{1, 1, 1, 1};

         System.out.println("Count of pairs is " +
                countPairsWithSum_ByHashMap(arr,7));
        System.out.println("Count of pairs is " +
                countPairsWithSum_ByHashMap(arr1,sum));

    }
}
