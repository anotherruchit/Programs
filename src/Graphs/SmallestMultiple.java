package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ruchitmehta
 * https://www.interviewbit.com/problems/smallest-multiple-with-0-and-1/
 * check this out: http://www.geeksforgeeks.org/find-the-smallest-binary-digit-multiple-of-given-number/
 * TODO: remaining
 *
 */
public class SmallestMultiple {

    public static void main(String args[]){
        SmallestMultiple multiple = new SmallestMultiple();
        multiple.smallestMultiple(2);
        multiple.smallestMultiple(55);
        multiple.smallestMultiple(3456);
    }

    public boolean smallestMultiple(int A){

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(A);
        int multiple = 2;

        while(!q.isEmpty()){

            int nextNum = A * multiple;
            multiple++;
            q.add(nextNum);

            if(checkValid(nextNum)){
                System.out.println(nextNum);
                return true;
            }
        }
        return  false;
    }

    public boolean checkValid(int num){
        while(num > 0){
            int lastDigit = num % 10;
            num = num / 10;
            if(lastDigit == 0 || lastDigit == 1)
                continue;
            else{
                return false;
            }
        }
        return true;

    }
}
