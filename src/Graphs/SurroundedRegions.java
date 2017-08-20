package Graphs;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by ruchitmehta
 * https://www.interviewbit.com/problems/capture-regions-on-board/
 */
public class SurroundedRegions {
    public static void main(String args[]){
        char[][] board = {{'X', 'X', 'X', 'X'},
                          {'X', 'O', 'O', 'X'},
                          {'X', 'X', 'O', 'X'},
                          {'X', 'O', 'X', 'X'}};
        SurroundedRegions region = new SurroundedRegions();
        region.solve(board);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public void solve(char[][] board) {
        if(board==null || board.length==0 || board[0].length==0)
            return;

        int m=board.length; // row
        int n=board[0].length; // col

//        System.out.println("row length " + m);
//        System.out.println("col length " + n);

        // first row
        for(int j=0; j<n; j++){
            if(board[0][j]=='O'){
                bfs(board, 0, j);
            }
        }

        //  last row
        for(int j=0; j<n; j++){
            if(board[m-1][j]=='O'){
                bfs(board, m-1, j);
            }
        }

        // first column
        for(int i=0; i<m; i++){
            if(board[i][0]=='O'){
                bfs(board, i, 0);
            }
        }

        // last column
        for(int i=0; i<m; i++){
            if(board[i][n-1]=='O'){
                bfs(board, i, n-1);
            }
        }


        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='1'){
                    board[i][j]='O';
                }
            }
        }
    }

    public void bfs(char[][] board, int o, int p){
        int m=board.length;
        int n=board[0].length;

//        System.out.println("o : " + o + " n : " + n + " p : " + p);
        int index = o*n+p;  // curr_row * col + curr_col
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(index);
        board[o][p]='1';

        while(!queue.isEmpty()){
            int top = queue.poll();
            int i=top / n;
            int j=top % n;
//            System.out.println("top : " + top + " i : " + i + " j : " + j);

            if(i-1>=0 && board[i-1][j]=='O'){
                board[i-1][j]='1';
                queue.offer((i-1)*n+j);
            }
            if(i+1<m && board[i+1][j]=='O'){
                board[i+1][j]='1';
                queue.offer((i+1)*n+j);
            }
            if(j-1>=0 && board[i][j-1]=='O'){
                board[i][j-1]='1';
                queue.offer(i*n+j-1);
            }
            if(j+1<n && board[i][j+1]=='O'){
                board[i][j+1]='1';
                queue.offer(i*n+j+1);
            }
        }
    }
}
