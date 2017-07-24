package Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ruchitmehta
 */
public class ThreeSumProblem {
    public static void main(String args[]){
        ThreeSumProblem sum = new ThreeSumProblem();
        List<Integer> list = Arrays.asList(-2, -1, 4, 7, 8, 12, 16);
        System.out.println(sum.threeSumProblem(list, 27));

        list = Arrays.asList(-10, -10, -10);
        System.out.println(sum.threeSumProblem(list, -5));


    }

    public int threeSumProblem(List<Integer> list, int target) {

        // sort the input list
        Collections.sort(list);

        int curr, left, right;
        int currSum;
        int oldDiff = 0;
        for (int i = 0; i < list.size() - 2; i++) {
            curr = i;
            left = i + 1;
            right = list.size() - 1;
            int res = list.get(0) + list.get(1) + list.get(2);

            while (left < right) {
                currSum = list.get(curr) + list.get(left) + list.get(right);

                if (currSum < target)
                    left++;
                else if (currSum > target)
                    right--;
                else if (currSum == target) {
                    return curr;
                }


                int newDiff = Math.abs(target - currSum);
                oldDiff = Math.abs(target - res);

                if (oldDiff < newDiff)
                    res = newDiff;
            }
        }

        return oldDiff;

    }
}
