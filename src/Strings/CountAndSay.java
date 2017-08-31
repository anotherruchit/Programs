package Strings;

/**
 * Created by ruchitmehta.
 * https://www.interviewbit.com/problems/count-and-say/
 * Problem Statement: The count-and-say sequence is the sequence of integers beginning as follows:
 *                  1, 11, 21, 1211, 111221, ...
 */
public class CountAndSay {

    public static void main(String args[]){
        System.out.println(sayAndCount(5));
    }

    public static String sayAndCount(int n){
        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;

        for(int i = 1; i < n; i++){
            prev = curr;
            curr = new StringBuilder();
            count = 1;
            say = prev.charAt(0);
            int len = prev.length();
            for(int j = 1; j < len; j++){
                if(prev.charAt(j) != say){
                    curr.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                } else
                    count++;
            }
            curr.append(count).append(say);
        }
        return curr.toString();
    }
}
