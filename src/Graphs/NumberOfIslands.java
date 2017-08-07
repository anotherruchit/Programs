package Graphs;

/**
 * Created by ruchitmehta
 * http://www.geeksforgeeks.org/find-number-of-islands/
 * https://www.interviewbit.com/problems/black-shapes/
 * Time Complexity: O(ROW x COL)
 */
public class NumberOfIslands {
    private static final int  ROW = 5, COL = 5;
    public static void main(String args[]){
        int M[][]=  new int[][] {{1, 1, 0, 0, 0},
                                 {0, 1, 0, 0, 1},
                                 {1, 0, 0, 1, 1},
                                 {0, 0, 0, 0, 0},
                                 {1, 0, 1, 0, 1},
                                 {1, 0, 1, 0, 1}
        };

        System.out.println(M[0].length);
        System.out.println(M.length);
        NumberOfIslands I = new NumberOfIslands();
        System.out.println("Number of islands is: "+ I.countIslands(M));
    }

    // main function that returns count of islands
    public int countIslands(int M[][]){
        boolean[][] visited = new boolean[ROW][COL];

        int count = 0;

        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(M[i][j] == 1 && !visited[i][j]){
                    dfs(M, i, j, visited);
                    count++;
                }
            }
        }
        return  count;
    }

    // A utility function to do DFS for a 2D boolean matrix.
    // It only considers the 8 neighbors as adjacent vertices
    public void dfs(int[][] M, int row, int col, boolean[][] visited){
        int rowNumber[] = new int[]{-1, 0, 1, 0};
        int colNumber[] = new int[]{0, 1, 0, -1};

        visited[row][col] = true;

        for(int k = 0; k < 4; k++){
            if(isSafe(M, row + rowNumber[k], col + colNumber[k], visited))
                dfs(M, row + rowNumber[k], col + colNumber[k], visited);
        }
    }

    public boolean isSafe(int[][] M, int row, int col, boolean[][] visited){
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0 && col >= 0 && row < ROW && col < COL && !visited[row][col] && M[row][col] == 1);
    }
}
