package Strings;

import java.util.ArrayList;

/**
 * Created by ruchitmehta on 7/2/17.
 * https://www.interviewbit.com/problems/longest-common-prefix/
 * https://leetcode.com/problems/longest-common-prefix/solution/#approach-3-divide-and-conquer
 */
public class LongestCommonPrefix {

    public static void main(String args[]){
        ArrayList<String> list = new ArrayList<>();
        list.add("abcd");
        list.add("abcfs");
        list.add("abctws");
        list.add("abrwe");
        System.out.println(longestCommonPrefix(list));
    }

    /*
    https://leetcode.com/problems/longest-common-prefix/solution/#approach-3-divide-and-conquer
    Approach 2 - Vertical Scanning
    Time Complexity - O(S) where S is sum of all chars in all strings
    Space Complexity - O(1)
     */
    public static String longestCommonPrefix(ArrayList<String> list){
        if(list.size() == 0)
            return "";

        String res = "";
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < list.size(); i++){
            min = Math.min(min, list.get(i).length());
        }

        for(int i = 0; i < min; i++){
            char c = list.get(0).charAt(i);
            for(int j = 0; j < list.size(); j++){
                if(c != list.get(j).charAt(i))
                    return res;
            }
            res = res + c;
        }

        return res;
    }
}
