package Strings;

import java.util.HashSet;

/**
 * Created by ruchitmehta
 * hackerrank test 2 - codepath
 */
public class FirstRepeatedWord {
    public static void main(String args[]){
        System.out.println(firstRepeatedWord("He had had quite enough of this nonsense"));
    }

    static String firstRepeatedWord(String str) {
        // store the words in the set to find duplicate
        HashSet<String> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        if(str.length() == 0 || str == null)
            return "";

        for(int i = 0;i < str.length(); i++){
            if(str.charAt(i) != ' ' && str.charAt(i) != '\t' && str.charAt(i) != '.' && str.charAt(i) != ':' && str.charAt(i) != ';' && str.charAt(i) != '-'){
                builder.append(str.charAt(i));
            } else {

                String word = builder.toString();
                if(set.contains(word)){
                    return word;
                } else {
                    set.add(word);
                    builder = new StringBuilder();
                }
            }
        }
        return "";
    }
}
