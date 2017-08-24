package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruchitmehta on 8/9/17.
 * https://leetcode.com/problems/generate-parentheses/
 * Problem Statement: Given n, write a function to generate all n-pairs of combinations of well-formed parentheses.
 */
public class GenerateParanthesis {
    public static void main(String args[]){
        List<String> result = generatePranthesis(3);
        for(String s : result){
            System.out.println(s);
        }
    }

    static List<String> generatePranthesis(int n){
        List<String> result = new ArrayList<>();
        generate(result, "", n, n);
        return result;
    }

    static void generate(List<String> result, String str, int left, int right){
        if(left > right)
            return;

        if(left == 0 && right == 0){
            result.add(str);
            return;
        }

        if(left > 0){
            generate(result, str + "(", left-1, right);
        }

        if(right > 0){
            generate(result, str + ")", left, right-1);
        }

    }
}
