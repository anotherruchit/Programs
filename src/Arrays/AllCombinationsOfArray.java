package Arrays;

/**
 * Created by ruchitmehta
 * https://www.youtube.com/watch?v=p8SDPaX1wgw
 * Time Complexity - 2^n , where n is number of elements in the array.
 * To handle duplicate elements, sort the array and do the steps mentioned here http://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
 *
 */
public class AllCombinationsOfArray {
    public static void main(String args[]){
        int[] data = {1, 2, 3, 4};
        makeCombinations(new int[data.length], data, 0, data.length-1);
    }

    static void makeCombinations(int[] arr, int data[], int k, int n){
        if(k == n){
            arr[k] = 0;
            printCombinations(arr, data);
            arr[k] = 1;
            printCombinations(arr, data);
            return;
        }

        arr[k] = 0;
        makeCombinations(arr, data, k+1, n);
        arr[k] = 1;
        makeCombinations(arr, data, k+1, n);

    }

    static void printCombinations(int[] arr, int[] data){
        int sum = 0;
        System.out.print("{ ");
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1){
                System.out.print(data[i] + " ");
            }
            sum++;
        }
        System.out.println("} ");

    }
}
