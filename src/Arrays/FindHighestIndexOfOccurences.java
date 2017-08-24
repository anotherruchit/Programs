package Arrays;

/**
 * Created by ruchitmehta on 8/23/17.
 * https://www.careercup.com/question?id=6194336212451328\
 * Problem Statement: Jacob and Peter have their fav. number x and y. We have given and array
 *                  with positive integer number and we need to find the longest prefix
 *                  index which contains equal number of x and y. Return -1 if there is no
 *                  prefix with equal number of x and y.
 */
public class FindHighestIndexOfOccurences {
    public static void main(String args[]){
        getHighestIndex(new int[]{1, 5, 5, 10, 10, 7, 5, 10, 6, 9, 14, 5, 10, 7, 9, 4}, 5, 10);
        getHighestIndex(new int[]{7, 42, 5, 6, 42, 8, 7, 5, 3, 6, 7}, 7, 42);
    }

    public static void getHighestIndex(int[] arr, int x, int y){
        if(arr == null || arr.length == 0)
            return;
        int startIndex = -1, endIndex = -1;
        int xCount = 0, yCount = 0;

        for(int i = 0; i < arr.length; i++){

            if(arr[i] == x){
                if(startIndex == -1)
                    startIndex = i;
                xCount++;
            }
            if(arr[i] == y){
                if(startIndex == -1)
                    startIndex = i;
                yCount++;
            }

            if(xCount == yCount)
                endIndex = i;
        }

        if(endIndex == -1){
            System.out.println("No matches to x and y found.");
        } else {
            System.out.println("startIndex " + startIndex + " endIndex " + endIndex);
        }
    }
}
