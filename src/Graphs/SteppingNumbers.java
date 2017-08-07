package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ruchitmehta
 * http://www.geeksforgeeks.org/stepping-numbers/
 * https://www.interviewbit.com/problems/stepping-numbers/
 */
public class SteppingNumbers {
    public static void main(String args[]){
        int n = 12, m = 200;

        // Display Stepping Numbers in
        // the range [n,m]
        displaySteppingNumber(n,m);
    }

    public static void displaySteppingNumber(int n, int m){

        for(int i = 0; i <= 9; i++){
            bfs(n, m, i);
        }
    }

    public static void bfs(int n, int m, int k){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);

        while(! queue.isEmpty()){

            int curr = queue.poll();

            if(curr >= n && curr <= m)
                System.out.print(curr + " ");

            if(curr == 0 || curr >= m)
                continue;

            int right = curr % 10;

            int stepNumA = curr*10 + (right-1);
            int stepNumB = curr*10 + (right+1);

            if(right == 0)
                queue.add(stepNumB);
            else if(right == 9)
                queue.add(stepNumA);
            else{
                queue.add(stepNumA);
                queue.add(stepNumB);
            }
        }
    }
}
