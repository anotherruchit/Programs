package Arrays;

import java.util.Comparator;

/**
 * Created by ruchitmehta on 8/21/17.
 * https://www.youtube.com/watch?v=SzzSwvQfKyk
 */
public class ArrayComparator implements Comparator<Player> {
    /*
        x.compareTo(y):
        negative value: if x < y (x should appear first)
        zero: x == y
        positive value: if x > y (y should appear first)
     */
    @Override
    public int compare(Player p1, Player p2) {
        if(p1.score == p2.score){
            // compare by names
            p1.name.compareTo(p2.name);
        }
        return p2.score - p1.score;
    }
}


class Player{
    String name;
    int score;
}