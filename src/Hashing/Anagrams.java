package Hashing;

import java.util.*;

/**
 * Created by dharabavishi on 6/27/17.
 * https://www.interviewbit.com/problems/anagrams/
 */
public class Anagrams {

    public static void main(String args[]){
        List<String> a = new ArrayList<String>();
        a.add("cat");
        a.add("dog");
        a.add("god");
        a.add("atc");
        a.add("tac");
        ArrayList<ArrayList<Integer>> result = anagrams(a);
        for(int i = 0; i < result.size(); i++){
            System.out.print("[ ");
            for(int j : result.get(i))
                System.out.print((j) + " ");
            System.out.println("]");
        }
    }

    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
        int i = 1;

        for (String str : A) {

            char [] array = str.toCharArray();
            Arrays.sort(array);
            String sorted = new String(array);

            if (hashMap.containsKey(sorted)) {
                ArrayList<Integer> list = hashMap.get(sorted);
                list.add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(sorted, list);
            }

            i++;

        }

        for (Map.Entry<String, ArrayList<Integer>> entrySet : hashMap.entrySet()) {
            res.add(entrySet.getValue());
        }

        return res;

    }

}
