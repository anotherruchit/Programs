package Arrays;

/**
 * Created by ruchitmehta
 * http://www.geeksforgeeks.org/print-all-combinations-of-given-length/
 */
public class AllCombinationsOfArrayTwo {
    public static void main(String args[]){

        char[] set1 = {'a', 'b'};
        printAllKLength(set1, 3);
    }

    static void printAllKLength(char[] array, int k){
        int n = array.length;

        combinations(array, "", k, n);

    }

    static void combinations(char[] array, String prefix, int k, int length){

        // base case
        if(k == 0){
            System.out.println(prefix);
            return;
        }

        for(int i = 0; i < length; i++){
            String newPrefix = prefix + array[i];

            combinations(array, newPrefix, k-1, length);
        }
    }
}
