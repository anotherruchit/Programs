package Graphs;

/**
 * Created by ruchitmehta on 8/9/17.
 * https://www.youtube.com/watch?v=R4Nh-EgWjyQ
 */
public class ConnectedCells {
    public static void main(String args[]){
        char[][] board = {{'O', 'O', 'O', '1', '1', 'O', 'O'},
                          {'O', '1', 'O', 'O', '1', '1', 'O'},
                          {'1', '1', 'O', '1', 'O', 'O', '1'},
                          {'O', 'O', 'O', 'O', 'O', '1', 'O'},
                          {'1', '1', 'O', 'O', 'O', 'O', 'O'}};

        System.out.println(getRegion(board));

    }

    static int getRegion(char[][] board){
        int maxRegionSize = 0;
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] == '1'){
                    int size = dfs(board, r, c);
                    maxRegionSize = Math.max(maxRegionSize, size);
                }
            }
        }
        return maxRegionSize;
    }

    static int dfs(char[][] board, int row, int col){

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length)
            return 0;

        if(board[row][col] == 'O')
            return 0;

        int size = 1;
        board[row][col] = 'O';
        for(int r = row - 1; r <= row + 1; r++){
            for(int c = col - 1; c <= col + 1; c++){
                if(r != row || c != col){
                    size += dfs(board, r, c);
                }
            }
        }
        return size;
    }

}
