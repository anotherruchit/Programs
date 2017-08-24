package Strings;

import java.util.Hashtable;

/**
 * Created by ruchitmehta on 8/23/17.
 * Microsoft Interview Question
 * https://discuss.leetcode.com/topic/92112/java-solution-boolean-array
 * Problem Statement: Given the String str and a list of string, provide the bold tag before and after the strings in the list
                    eg: str = "HelloWorld HelloWorld"
                        list = ["el", "rl"]
                        output = "H<b>el</b>loWo<b>rl</b>d H<b>el</b>loWo<b>rl</b>d"
 */
public class AddBoldTag {
    public static void main(String args[]){
//        makeBold("HelloWorld HelloWorld", Arrays.asList("el"));
        System.out.println(addBoldTag("HelloWorld HelloWorld", new String[]{"el", "rl"}));
    }

    public static String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (int i = 0, end = 0; i < s.length(); i++) {
            for (String word : dict) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            bold[i] = end > i;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) {
                result.append(s.charAt(i));
                continue;
            }
            int j = i;
            while (j < s.length() && bold[j]) j++;
            result.append("<b>" + s.substring(i, j) + "</b>");
            i = j - 1;
        }
        return result.toString();
    }

}
