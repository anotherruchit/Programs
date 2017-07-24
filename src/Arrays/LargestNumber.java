package Arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ruchitmehta
 *
 * https://www.interviewbit.com/problems/largest-number/
 *
 * In terms of Time and Space Complexity:
 Let's assume:
 the length of input array is n,
 average length of Strings in s_num is k,
 Then, compare 2 strings will take O(k).
 Sorting will take O(nlgn)
 Appending to StringBuilder takes O(n).
 So total will be O(nklgnk) + O(n) = O(nklgnk).

 Space is pretty straight forward: O(n).

 */
public class LargestNumber {
    public static void main(String args[]){

        LargestNumber largest = new LargestNumber();
        int[] num = {3, 30, 34, 5, 9};
        System.out.println(largest.largestNumber(num));
        int[] num1 = {0, 0, 0, 0, 0};
        System.out.println(largest.largestNumber(num1));
    }

    public String largestNumber(int[] arr){

        if(arr.length == 0 || arr == null)
            return "";

        // Convert int array to String array, so we can sort later on
        String[] stringNum = new String[arr.length];
        for(int i = 0; i < arr.length; i++){
            stringNum[i] = String.valueOf(arr[i]);
        }

        Comparator<String> compare = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };

        Arrays.sort(stringNum, compare);

//        System.out.println(Arrays.toString(stringNum));
        StringBuilder builder = new StringBuilder();
        for(String s : stringNum){
            builder.append(s);
        }

        // remove all the leading 0's
        while(builder.charAt(0)=='0' && builder.length()>1)
            builder.deleteCharAt(0);

        return builder.toString();
    }
}
