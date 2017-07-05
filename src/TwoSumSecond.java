import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dharabavishi on 6/15/17.
 */
public class TwoSumSecond {
    public static void main(String args[]){
        int[] numbers = new int[]{1, -5, 4, 2, 4, 5, 1};
        int target = 6;
        int[] result = twoSum(numbers, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] numbers, int target){
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.length; i++){
            if(map.containsKey(target - numbers[i])){
                result[1] = i + 1;
                result[0] = map.get(target - numbers[i]);
//                return result;
            }
            else {
                map.put(numbers[i], i + 1);
            }
        }

        return result;
    }
}
