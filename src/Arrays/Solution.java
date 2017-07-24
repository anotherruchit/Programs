package Arrays;

import java.util.*;

/**
 * Created by ruchitmehta
 */
public class Solution {
    public static void main(String args[]){
        Solution ob = new Solution();
        List<Integer> list = Arrays.asList(4,5,7,8);
        System.out.println(ob.findMissingNumber(list));


        System.out.println("length of substring : " +ob.findLength("abcdafe"));
    }

    public int findMissingNumber(List<Integer> list){

        if(list.size() == 0 || list == null)
            return 0;

        HashSet<Integer> set = new HashSet<Integer>();

        for(int i = 0; i < list.size(); i++){
            if(list.get(i) > 0){
                System.out.println("adding " + list.get(i));
                set.add(i);
            }
        }

        if(set.size() == 0)
            return 0;
        System.out.println("size " + set.size());

        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            int curr = iterator.next();
            System.out.println("curr value : "+ curr);
            int next = ++curr;
            System.out.println("searching " + next);
            if(!set.contains(next)){
                return next;
            }
        }
        return 0;
    }

    private int findLength(String s) {

        Map<Character, Integer> map = new HashMap();

        int max = 0;
        int start = 0;

        for(int i=0; i<s.length(); i++) {

            char c = s.charAt(i);

            if(map.containsKey(c) && map.get(c) >= start) {
                max = Math.max(max, i - start);
                start = map.get(c) + 1;
            }

            map.put(c, i);
        }

        max = Math.max(max, s.length() - start);
        return max;
    }
}
