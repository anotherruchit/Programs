package Arrays;

import java.util.*;

/**
 * Created by ruchitmehta
 */
public class Solution {
    public static void main(String args[]){
//        Solution ob = new Solution();
//        List<Integer> list = Arrays.asList(4,5,7,8);
//        System.out.println(ob.findMissingNumber(list));
//
//
//        System.out.println("length of substring : " +ob.findLength("abcdafe"));

        setArray(new int[]{1, 0, 0 , 4, 0 , 3, 0});
        System.out.println();
        setArrayInOrder(new int[]{1, 0, 0 , 4, 0 , 3, 0});

        System.out.println();

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,0,4,2,0,0,4));
        list.remove(2);
        for(int i : list){
            System.out.print(i +" ");
        }
    }


    static void setArrayInOrder(int[] array){

        int start = 0;
        int end = 1;
        while(end < array.length - 1){
            // find 0
            while(array[start] != 0 && start < array.length-1){
                start++;
            }
            // find non-zero
            while(array[end] == 0 && end < array.length-1){
                end++;
            }

            if(array[start] == 0 && array[end] != 0){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }

        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    static void setArray(int[] array){
        int start = 0;
        int end = array.length - 1;
        while(start <= end){
            while(array[start] != 0){
                start++;
            }
            while(array[end] == 0){
                end--;
            }

            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }

        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
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
