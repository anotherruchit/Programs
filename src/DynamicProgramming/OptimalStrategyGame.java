package DynamicProgramming;

/**
 * Created by ruchitmehta on 9/3/17.
 * https://www.glassdoor.com/Interview/N-pots-each-with-some-number-of-gold-coins-are-arranged-in-a-line-You-are-playing-a-game-against-another-player-You-tak-QTN_350584.htm
 * Problem statement: N pots, each with some number of gold coins, are arranged  in a line. You are playing a game
 *                  against another player. You take turns picking a pot of gold. You may pick a pot from either end
 *                  of the line, remove the pot, and keep the gold pieces. The player with the most gold at the end wins.
 *                  Develop a strategy for playing this game.
 *
 * https://www.youtube.com/watch?v=WxpIHvsu1RI
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/NPotGold.java
 */
public class OptimalStrategyGame {

    static class Pair{
        int first, second;
        int pick = 0;
        public String toString(){
            return first + " " + second + " " + pick;
        }
    }

    public static void main(String args[]){
        int pots[] = {3,1,5,6,2,9,3};
        Pair[][] moves = findMoves(pots);
        for(int i=0; i < moves.length; i++){
            for(int j=0; j < moves[i].length; j++){
                System.out.print(moves[i][j] + "  ");
            }
            System.out.print("\n");
        }
        System.out.println("The moves by first player and second player:");
        printSequence(pots, moves);
    }

    public static Pair[][] findMoves(int pots[]){
        Pair[][] moves = new Pair[pots.length][pots.length];

        for(int i=0; i < moves.length; i++){
            for(int j=0; j < moves[i].length; j++){
                moves[i][j] = new Pair();
            }
        }

        for(int i=0; i < pots.length; i++){
            moves[i][i].first = pots[i];
            //to track the sequence of moves
            moves[i][i].pick = i;
        }

        for(int l = 2; l <= pots.length; l++){ // length of pot
            for(int i = 0; i <= pots.length - l; i++){
                int j = i + l - 1;
                if(pots[i] + moves[i+1][j].second > moves[i][j-1].second + pots[j]){
                    moves[i][j].first = pots[i] + moves[i+1][j].second;
                    moves[i][j].second = moves[i+1][j].first;
                    moves[i][j].pick = i;
                }else{
                    moves[i][j].first = pots[j] + moves[i][j-1].second;
                    moves[i][j].second = moves[i][j-1].first;
                    moves[i][j].pick = j;
                }
            }
        }

        return moves;
    }

    //prints the sequence of values and indexes
    public static void printSequence(int pots[], Pair moves[][]){
        int i = 0;
        int j = pots.length - 1;
        int step;
        for (int k = 0; k < pots.length; k++) {
            step = moves[i][j].pick;
            //this is the value of pick and its index
            System.out.print("value: " + pots[step] + " " + "index: " + step + ", ");
            if (step <= i) {
                i = i + 1;
            } else {
                j = j - 1;
            }
        }
    }
}
