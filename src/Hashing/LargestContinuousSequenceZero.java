package Hashing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dharabavishi on 6/27/17.
 * https://www.interviewbit.com/problems/largest-continuous-sequence-zero-sum/
 */
public class LargestContinuousSequenceZero {

    public static void main(String args[]){
        ArrayList<Integer> A = new ArrayList<Integer>();
        //A : [ -1, 1, 1, -1, -1, 1, 1, -1 ]
        A.add(-1);
        A.add(1);
        A.add(1);
        A.add(-1);
        A.add(-1);
        A.add(1);
        A.add(1);
        A.add(-1);
        A.add(1);

        System.out.println(A);
        ArrayList<Integer> result = lszero(A);
        System.out.println(result);

        A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(-2);
        A.add(4);
        A.add(-4);

        System.out.println(A);
        result = lszero(A);
        System.out.println(result);
    }

    public static ArrayList<Integer> lszero(ArrayList<Integer> A){
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        if(A == null)
            return result;
        int len = 0, sum = 0, l = -1, r = -1;
        map.put(0, -1);

        for(int i = 0 ; i < A.size(); i++){
            sum += A.get(i);

            if(!map.containsKey(sum)){
                map.put(sum, i);
            } else {
                if(i - map.get(sum) > len){
                    l = map.get(sum) + 1;
                    r = i;
                    len = i - map.get(sum);
                }
            }
        }

        if(r >= 0 && l >= 0){
            for(int i = l; i <= r; i++){
                result.add(A.get(i));
            }
        }

        return result;

    }
}
