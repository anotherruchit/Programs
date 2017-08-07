package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
/**
 * Created by ruchitmehta
 *
 * Asked in phone interview of WealthFront
 *
 *  // a list of numbers: [3, 1, 2, 300, 1000, 400, 200, 750, -150, 300]
    // a goal number: 600

 // Pairs: (400,200), (750,-150), (300,300)

 // What if
 hashcode in Long class is defined as : it returns 1 instead of hash of the object
    public class Long {
        public int hashCode() { return 1; }
        ...
    }
 */
public class WealthfrontTwoSum {

    static class Pair<A, B> {

        public final A left;
        public final B right;

        Pair(A left, B right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return (this.left + " " + this.right);
        }

    }

    static List<Pair<Long, Long>> findSummingPairs(List<Long> numbers, Long goal) {
        Map<Long, Long> map = new HashMap<>();
        List<Pair<Long, Long>> result = new ArrayList<>();

        Pair<Long, Long> pair;
        Long complement;

        // if input list is empty
        if(numbers.size() == 0 || numbers.size() == 1)
            return result;

        // add the numbers from the list to hashmap
        for(int i = 0; i < numbers.size() ; i++){
            map.put(numbers.get(i), numbers.get(i));
        }

        // check if the pair exists in the list
        for(int i = 0; i < numbers.size(); i++){
            complement = goal - numbers.get(i);
            if(map.containsKey(complement)){

                pair = new Pair<Long, Long>(map.get(complement), numbers.get(i));
                result.add(pair);
                // important : to remove the entry from the hashmap so that it does not
                // create duplicate entry in output
                map.remove(numbers.get(i));

            }
        }

        return result;

    }

    public static void main(String[] args) {

        // important how to define Long
        List<Long> input = Arrays.asList(3L, 1L, 2L, 300L, 1000L, 400L, 200L, 750L, -150L, 300L);
        // important : how to override toString method so that it gives output instead of reference
        System.out.println(findSummingPairs(input, 600L).toString());

    }
}
