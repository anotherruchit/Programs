import java.util.ArrayList;
import java.util.List;

/**
 * Created by dharabavishi on 6/17/17.
 * https://leetcode.com/problems/generate-parentheses/#/description
 */
public class GenerateParanthesis {
    public static void generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        System.out.println(list.toString());
    }

    public static List<String> backtrack(List<String> list, String str, int open, int close, int max) {

        if (str.length() == max * 2) {
            list.add(str);
            return list;
        }

        if (open < max)
            backtrack(list, str + "(", open + 1, close, max);
        if (close < open)
            backtrack(list, str + ")", open, close + 1, max);
        return list;
    }

    public static void main(String args[]){
        generateParenthesis(3);
    }

}
