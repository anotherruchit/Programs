package Strings;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by dharabavishi on 6/17/17.
 */
public class ReverseWordsInString {
//    static String reverseString(String input){
//        final StringBuilder word = new StringBuilder();
//        final StringBuilder result = new StringBuilder();
//
//        for(int i = 0; i < input.length(); i++){
//            if(input.charAt(i) != ' '){
//                word.append(input.charAt(i));
//            }
//        }
//
//        return null;
//    }

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
//        reverseString("ruchit mehta is looking for a job");
        String[] splittedString = split("ruchit mehta is looking for a job");
        System.out.println(Arrays.toString(splittedString));
    }
}
