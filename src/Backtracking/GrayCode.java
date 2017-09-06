package Backtracking;

import java.util.ArrayList;

/**
 * Created by ruchitmehta on 8/3/17.
 * https://www.interviewbit.com/problems/gray-code/
 *
 */
public class GrayCode {

    public static void main(String args[]){
        GrayCode code = new GrayCode();

        System.out.println(code.grayCode(3).toString());

    }

    public ArrayList<Integer> grayCode(int A) {
        ArrayList<Integer> res;
        res = solve(A);
        return res;
    }

    public ArrayList<Integer> solve(int n) {

        if (n == 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(0);
            return temp;
        }

        ArrayList<Integer> gray = solve(n - 1);
        int num;

        System.out.println("Gray arraylist is " + gray.toString());

        for (int i = gray.size() - 1; i >= 0; i--) {
            num = gray.get(i);
            int temp = (1 << (n - 1));
            System.out.println("Got temp " + temp);
            num |= temp;
            System.out.println("adding num " + num);
            gray.add(num);
        }

        return gray;
    }

}
