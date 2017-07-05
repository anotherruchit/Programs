package Hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by dharabavishi on 6/27/17.
 */
public class ValidSudoku {

    //["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]

    public static int isValidSudoku(final List<String> A) {

        if (A == null)
            return 0;

        int n = A.size();

        if (n != 9 || A.get(0).length() != 9)
            return 0;

        HashSet<Character> hashSet = new HashSet<>();

        //check each row
        for (int i = 0; i < 9; i++) {
            hashSet.clear();
            for (int j = 0; j < 9; j++) {
                char c = A.get(i).charAt(j);
                if (c == '.')
                    continue;
                if (hashSet.contains(c))
                    return 0;
                hashSet.add(c);
            }
        }

        //check each column
        for (int i = 0; i < 9; i++) {
            hashSet.clear();
            for (int j = 0; j < 9; j++) {
                char c = A.get(j).charAt(i);
                if (c == '.')
                    continue;
                if (hashSet.contains(c))
                    return 0;
                hashSet.add(c);
            }
        }

        //check each 3*3 matrix
        for (int k = 0; k < 9; k++) {
            int x = k / 3;
            int y = k % 3;
            hashSet.clear();
            for (int i = 3 * x; i < 3 * x + 3; i++) {
                for (int j = y * 3; j < y * 3 + 3; j++) {
                    char c = A.get(j).charAt(i);
                    if (c == '.')
                        continue;
                    if (hashSet.contains(c))
                        return 0;
                    hashSet.add(c);
                }
            }
        }
        return 1;
    }

    public static void main(String[] args){
        List<String> a = new ArrayList<String>();
        a.add("..5.....6");
        a.add("....14...");
        a.add(".........");
        a.add(".....92..");

        a.add("5....2...");
        a.add(".......3.");
        a.add("...54....");
        a.add("3.....42.");
        a.add("...27.6..");

        System.out.println(isValidSudoku(a));
    }
}
