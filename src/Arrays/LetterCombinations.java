package Arrays;

import java.util.*;

/**
 * Created by ruchitmehta
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/#/description
 */
public class LetterCombinations {

    public static void main(String args[]){
        LetterCombinations combo = new LetterCombinations();
        combo.phoneNumberCombinations("235");
        ArrayList<ArrayList<Integer>> megaList = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2));
        megaList.add(list);
        list = new ArrayList<>(Arrays.asList(3,4,22));
        megaList.add(list);
        list = new ArrayList<>(Arrays.asList(5,6,7));
        megaList.add(list);

        makeCombinations(megaList, new ArrayList<Integer>());

    }

    /*
        Recursive Approach
        TODO: Make this function similar to the Iterative function and the output should also be same
     */
    static void makeCombinations(ArrayList<ArrayList<Integer>> kSet, ArrayList<Integer> currSet){

        int length = currSet.size(); // 1
        // termination condition
        int kSetSize = kSet.size();

        if(length >= kSetSize){

            for(int i = 0; i < currSet.size(); i++){
                System.out.print(currSet.get(i) + " ");
            }
            System.out.println();
            return;
        }

        List<Integer> processSet = kSet.get(length);

        for(int i = 0; i < processSet.size(); i++){
            currSet.add(processSet.get(i));
            makeCombinations(kSet, currSet);
            currSet.remove(currSet.size()-1);
        }

    }

    /*
        Iterative Approach
     */
    public void phoneNumberCombinations(String number){

        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno" ,"pqrs", "tuv", "wxyz"};
        LinkedList<String> queue = new LinkedList<>();

        queue.add("");
        for(int i = 0; i < number.length(); i++){
            int currNum = Character.getNumericValue(number.charAt(i));

            while(queue.peek().length() == i){
                String currCombo = queue.remove();
                for(char c : mapping[currNum].toCharArray()){
                    queue.add(currCombo+c);
                }
            }
        }

        System.out.println(queue.toString());
    }


}
