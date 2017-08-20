package Strings;

import java.util.HashSet;

/**
 * Created by ruchitmehta on 8/12/17.
 * https://www.careercup.com/question?id=5157687156277248
 */
public class PassowrdPossbilities {
    private static HashSet<String> possibilities = new HashSet<>();

    public static void main(String args[]){
        String password = "password";

        getPoss("", password);
        System.out.println(possibilities);
    }

    public static void getPoss(String prefix, String rest){
        if(rest.length() > 0){
            possibilities.add(prefix+rest);

            if(rest.charAt(0) == 's'){
                getPoss(prefix+"$", rest.substring(1));
            }
            if(rest.charAt(0) == 'a'){
                getPoss(prefix+"@", rest.substring(1));
            }

            getPoss(prefix+rest.charAt(0), rest.substring(1));
        }
    }
}
