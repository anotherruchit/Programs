package BinarySearchProblems;

/**
 * Created by ruchitmehta on 8/9/17.
 * https://www.careercup.com/question?id=14608732
 * http://algorithms.tutorialhorizon.com/magic-index-find-index-in-sorted-array-such-that-ai-i/
 * Problem Statement: Given a sorted array of dis­tinct inte­gers, Find the Magic index or Fixed point in the array.
 *                  Magic index or a Fixed point in an array is an index i in the array such that A[i] = i
 */
public class MagicIndex {
    public static void main(String args[]){
        int[] array = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        MagicIndex magic = new MagicIndex();
        System.out.println(magic.magicIndex(array, 0, array.length-1));

        int[] array1 = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 12};
        System.out.println(magic.magicIndexWithRepetition(array1, 0, array1.length-1));
    }


    // Arrays without value repetition
     int magicIndex(int[] array, int start, int end){
        if(end < start)
            return -1;

        int midIndex = (start + end)/2;

        if(midIndex == array[midIndex]){
            return midIndex;
        }
        else if(array[midIndex] < midIndex){
            return magicIndex(array, midIndex+1, end);
        } else {
            return magicIndex(array, start, midIndex-1);
        }
    }

    // Arrays with value repetition
    int magicIndexWithRepetition(int[] array, int start, int end){
         if(end < start)
             return -1;

         int midIndex = (start + end)/2;
         int midValue = array[midIndex];

         if(midIndex == midValue)
             return midIndex;

         // search left
        int leftIndex = Math.min(midIndex - 1, midValue);
        int l = magicIndexWithRepetition(array, start, leftIndex);
        if(l >= 0)
            return l;

        int rightIndex = Math.max(midIndex+1, midValue);
        return magicIndexWithRepetition(array, rightIndex, end);
    }

}
