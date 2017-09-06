package Arrays;

/**
 * Created by ruchitmehta on 9/5/17.
 * Problem Staement: Find the contiguous subarray within an array (containing at least one number) which has the largest product.
                    For example, given the array [2,3,-2,4],
                    the contiguous subarray [2,3] has the largest product = 6
 */
public class MaxProductSubArray {
    public static void main(String args[]){
        System.out.println(maxProductSubArray(new int[]{2, -3, 2, 4}));
    }

    public static int maxProductSubArray(int[] array){
        if(array == null || array.length == 0)
            return 0;

        int maxHerePre = array[0];
        int minHerePre = array[0];
        int maxSoFar = array[0];
        int maxHere, minHere;

        for(int i = 1; i < array.length; i++){
            maxHere = Math.max(Math.max(maxHerePre * array[i], minHerePre * array[i]), array[i]);
            minHere = Math.min(Math.min(maxHerePre * array[i], minHerePre * array[i]), array[i]);
            maxSoFar = Math.max(maxHere, maxSoFar);
            maxHerePre = maxHere;
            minHerePre = minHere;
        }

        return maxSoFar;
    }
}
