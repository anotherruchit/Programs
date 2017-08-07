package Hashing;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by ruchitmehta on 6/27/17.
 * https://www.interviewbit.com/problems/4-sum/
 * https://github.com/nagajyothi/InterviewBit/blob/master/Hashing/FourSum.java
 */
public class FourSumProblem {

    public static ArrayList<ArrayList<Integer>> fourSumSolution(ArrayList<Integer> A, int target){

        Collections.sort(A);
        Integer[] num = new Integer[A.size()];
        num = A.toArray(num);

        HashSet<ArrayList<Integer>> hashSet = new HashSet<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i = 0; i < num.length; i++){
            for(int j = i + 1; j < num.length; j++){
                int k = j + 1;
                int l = num.length - 1;

                while(k < l){
                    int sum = num[i] + num[j] + num[k] + num[l];

                    if(sum < target)
                        k++;
                    else if (sum > target)
                        l--;
                    else if (sum == target){
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[k]);
                        temp.add(num[l]);

                        if(!hashSet.contains(temp)){
                            hashSet.add(temp);
                            result.add(temp);
                        }

                        k++;
                        l--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String args[]){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(0);
        a.add(-1);
        a.add(0);
        a.add(-2);
        a.add(2);
        ArrayList<ArrayList<Integer>> result = fourSumSolution(a, 0);
        for(int i= 0; i < result.size(); i++){
            for(int j : result.get(i))
                System.out.print(j + " ");
            System.out.println();
        }
    }
}
