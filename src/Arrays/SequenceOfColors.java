package Arrays;

import java.util.Stack;

/**
 * Created by ruchitmehta on 8/23/17.
 * https://www.careercup.com/question?id=5070235686141952
 * Problem Statement: You are given an array / sequence of colors. In this sequence / array, find a couple (both colors
 *                  adjacent to each other) which are same color. Now, remove that pair. Now, after this removal, if there are further couple of same color then remove that as well and so on.
                    For a given array / sequence of colors, find the maximum number of couples.

                     For eg., consider following array of colors :
                     R G B B G R Y

                     1. BB is one couple, so remove it :
                     R G G R Y
                     2. GG is one such couple after removing BB, so remove it :
                     R R Y
                     3. RR is one such couple, so remove it :
                     Y
                     So, the maximum number of couples is 3.
                     Input :
                     Y R G G R R G G R Y
                     Output :
                     5 (maximum number of couples)
 */
public class SequenceOfColors {
    public static void main(String args[]){
        PairsOfColors(new char[]{'r', 'g', 'b', 'b', 'g', 'r', 'y'});
    }

    public static int PairsOfColors(char[] colors){
        if(colors == null || colors.length == 0){
            return 0;
        }
        int numberOfPairs = 0;
        Stack<Character> colorStack = new Stack<>();

        for(int i = 0; i < colors.length; i++){
            if(colorStack.isEmpty()){
                colorStack.push(colors[i]);
            } else {
                Character c = colorStack.peek();
                if(c.equals(colors[i])){
                   colorStack.pop();
                   numberOfPairs++;
                } else {
                    colorStack.push(colors[i]);
                }
            }
        }

        System.out.println("Number of pairs " + numberOfPairs);
        return numberOfPairs;
    }
}
