package Arrays;

/**
 * Created by ruchitmehta on 8/11/17.
 * https://www.careercup.com/question?id=6312698670219264
 * Problem Statement : Write a method that takes an array of positive and negative integers and a number k. This method
 *                     should true if there is a contiguous subarray what sums upto k, or else false
 */
public class ArraySumK {
    public static void main(String args[]){
        System.out.println(arraySum(new int[]{10, 20, 12, -6, 14, 8}, 20));
    }

    static boolean arraySum(int[] array, int sum){
        if(array.length == 0)
            return false;
        if(array.length == 1){
            if(array[0] == sum)
                return true;
            else
                return false;
        }

        int currSum = array[0];
        int start = 0;
        for(int i = 1; i < array.length; i++){
            currSum = currSum + array[i];
            if(currSum == sum)
                return true;
            if(currSum > sum){
                currSum = currSum - array[start];
                start++;
            }
        }
        return false;
    }
}
