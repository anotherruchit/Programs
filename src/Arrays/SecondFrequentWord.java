package Arrays;

import java.util.*;

/**
 * Created by ruchitmehta on 8/12/17.
 * https://www.careercup.com/question?id=5748104113422336
 * http://www.geeksforgeeks.org/second-repeated-word-sequence/
 */
public class SecondFrequentWord {
    public static void main(String args[]){
        String arr[] = { "ccc", "aaa", "ccc",
                "ddd", "aaa", "aaa" };
        List<String> seq =  Arrays.asList(arr);

        System.out.println(secMostRepeated(new ArrayList<>(seq)));
    }

    public static String secMostRepeated(ArrayList<String> list){

        HashMap<String, Integer> countMap = new HashMap<String, Integer>();

        // Get the count of all the words in the HashMap
        for(int i = 0; i < list.size(); i++){
            if(countMap.containsKey(list.get(i))){
                countMap.put(list.get(i), countMap.get(list.get(i)) + 1);
            } else {
                countMap.put(list.get(i), 1);
            }
        }

        // Get the second most repeated value (count) in the hashmap
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        Iterator<Map.Entry<String, Integer>> it = countMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Integer> entry = it.next();
            int val = entry.getValue();
            if(val > firstMax){
                secondMax = firstMax;
                firstMax = val;
            } else if (val > secondMax && val != firstMax){
                secondMax = val;
            }
        }

        // parse the hash map and get the corresponding word
        it = countMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Integer> entry = it.next();
            if(entry.getValue() == secondMax){
                return entry.getKey();
            }
        }

        return null;
    }
}
