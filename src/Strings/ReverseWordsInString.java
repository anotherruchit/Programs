package Strings;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by ruchitmehta on 6/17/17.
 * https://www.programcreek.com/2014/02/leetcode-reverse-words-in-a-string-java/
 */
public class ReverseWordsInString {
    static String reverseString(String input){
        final StringBuilder word = new StringBuilder();
        final StringBuilder result = new StringBuilder();

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) != ' '){
                word.append(input.charAt(i));
            }
        }

        return null;
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // split to words by space
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; --i) {
            if (!arr[i].equals("")) {
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    static String[] split(String input){
        ArrayList<String> words = new ArrayList<>();
        StringBuilder splitword = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == ' '){
                words.add(splitword.toString());
                splitword = new StringBuilder();
            }else{
                splitword.append(input.charAt(i));
            }
        }

        words.add(splitword.toString());
        String[] splitWords = new String[words.size()];

        return words.toArray(splitWords);

    }

    public static void main(String args[]){
        reverseString("ruchit mehta is looking for a job");
        String[] splittedString = split("ruchit mehta is looking for a job");
        System.out.println(Arrays.toString(splittedString));

        String result = reverseWords("ruchit mehta is looking for a job");
        System.out.println(result);
    }
}
