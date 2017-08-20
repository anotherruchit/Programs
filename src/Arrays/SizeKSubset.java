package Arrays;

/**
 * Created by ruchitmehta
 * http://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
 */
public class SizeKSubset {
    public static void main(String args[]){
        int[] array = {1,2,3,4};
        boolean[] used = new boolean[array.length];

        printAllSizeKSubset(array, used, 0, 0, 3);

    }
//
    static void printAllSizeKSubset(int[] array, boolean[] used, int startIndex, int currentSize, int k){

        // recursion termination condition
        // case 1: when currentSize == k then print
        if(currentSize == k){
            for(int i = 0; i < array.length; i++){
                if(used[i] == true){
                    System.out.print(array[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        // case 2: startIndex exceeds size of array
        if(startIndex == array.length)
            return;

        // recursion step
        // first select startIndex
        used[startIndex] = true;
        printAllSizeKSubset(array, used, startIndex+1, currentSize+1, k);

        // do not select element at startIndex and move ahead
        used[startIndex] = false;
        printAllSizeKSubset(array, used, startIndex+1, currentSize, k);

    }
}
