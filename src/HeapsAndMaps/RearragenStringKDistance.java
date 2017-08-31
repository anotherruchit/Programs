package HeapsAndMaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by ruchitmehta
 * http://www.programcreek.com/2014/08/leetcode-rearrange-string-k-distance-apart-java/
 */
public class RearragenStringKDistance {
    public static void main(String args[]){
        System.out.println(rearrangeString("aaaabbbbcc", 4));
    }

    static String rearrangeString(String str, int k) {
        if(k==0)
            return str;

        //initialize the counter for each character
        final HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }

        //sort the chars by frequency (Descending order)
        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>(){
            public int compare(Character c1, Character c2){
                // if the count for 2 character is different
                if(map.get(c2).intValue() != map.get(c1).intValue()){
//                    System.out.print("Arranging characters -> " + c1 + " " + c2 + " with value ");
//                    System.out.println(map.get(c1).intValue() + " " + map.get(c2).intValue());
                    return map.get(c2)-map.get(c1);
                }else{
                    // if the count of 2 char is same then arrange according to character itself. eg: 'a' before 'b'
//                    System.out.println("Arranging characters :" + c1 + " " + c2);
                    return c1.compareTo(c2);
                }
            }
        });

        // Put all the characters from HashMap into PriorityQueue
        for(char c: map.keySet())
            queue.offer(c);

        StringBuilder sb = new StringBuilder();

        int len = str.length();

        while(!queue.isEmpty()){

            int cnt = Math.min(k, len);
            ArrayList<Character> temp = new ArrayList<Character>();

            for(int i=0; i<cnt; i++){
                if(queue.isEmpty())
                    sb.append("_");
                else {
                    char c = queue.poll();
//                    System.out.println("Current character into consideration: " + c);
                    sb.append(String.valueOf(c));

                    map.put(c, map.get(c)-1);

                    if(map.get(c)>0){
                        temp.add(c);
                    }

                    len--;
                }
            }
//            System.out.println("coming out, going for 2nd round");
            for(char c: temp)
                queue.offer(c);
        }

        return sb.toString();
    }
}
