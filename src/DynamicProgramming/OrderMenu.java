package DynamicProgramming;

import java.util.*;

/**
 * Created by ruchitmehta on 8/9/17.
 *
 * Nest Interview Question - https://xkcd.com/287/
 */
public class OrderMenu {

    static private HashSet<List<String>> set = new HashSet<>();

    public static void main(String[] args) {

        HashMap<String, Double> menu = new HashMap<String, Double>();
        menu.put("mixed fruit", 2.15);
        menu.put("french fries", 2.75);
        menu.put("side salads", 3.35);
        menu.put("hot wings", 3.55);
        menu.put("mozarella", 4.20);
        menu.put("sampler plate", 5.80);

//        printAllPremutationOfStrings("ABC");
        getAllPremutationsOfItems(menu, 15.05);
    }

    static void getAllPremutationsOfItems(HashMap<String, Double> menu, Double bill){
        allPermutationsOfItems(menu, bill, "", 0.0, new ArrayList<>(menu.keySet()));
    }

    static void allPermutationsOfItems(HashMap<String, Double> menu, Double bill, String order, Double currTotal, List<String> items){
        if(currTotal.equals(bill)){
            if(checkIfOrderDoesNotExist(order)){
                System.out.println(order);
            }
            return;
        }

        if(currTotal > bill){
            return;
        }

        for(int i = 0; i < menu.size(); i++){
            allPermutationsOfItems(menu, bill, order + items.get(i) + " ", currTotal + menu.get(items.get(i)), items);
        }
    }

    static boolean checkIfOrderDoesNotExist(String order){
        String[] temp = order.split(" ");
        Arrays.sort(temp);
        List<String> list = new ArrayList<>(Arrays.asList(temp));

        if(!set.contains(list)){
            set.add(list);
            return true;
        } else {
            return false;
        }
    }

    /*
        Generic Method to check different premuations of string - "abc"
     */
    static void printAllPremutationOfStrings(String str){
        allPermutations(str, str.length(), "");
    }

    static void allPermutations(String str, int n, String newString){
        if(n == newString.length()){
            if(checkIfCombinationDoesNotExist(newString)){
                System.out.println(newString);
            }
            return;
        }

        for(int i = 0; i < str.length(); i++){
            allPermutations(str, n, newString+str.charAt(i));
        }
    }

    static boolean checkIfCombinationDoesNotExist(String str){

        String[] temp = str.split("");
        Arrays.sort(temp);
        List<String> list = new ArrayList<>(Arrays.asList(temp));

        if(!set.contains(list)){
            set.add(Arrays.asList(str.split("")));
            return true;
        } else {
            return false;
        }
    }

//    static List<ArrayList<String>> calculateMenu(HashMap<String, Float> menu, Float bill){
//
//        List<ArrayList<String>> result = new ArrayList<>();
//        Float currTotal = 0f;
//        List<String> keys = new ArrayList<String>(menu.keySet());
//
//        ArrayList<String> order = new ArrayList<String>();
//
//        for(int i = 0; i < menu.size(); i++){
//
//            currTotal = 0f;
//
//            String item = keys.get(i);
//            currTotal += menu.get(item);
//            System.out.println("current total out : " + currTotal);
//            order.add(keys.get(i));
//
//            for(int j = 0; j < menu.size(); j++){
//                String item2 = keys.get(j);
//                currTotal += menu.get(item2);
//                System.out.println("current total in : " + currTotal);
//                order.add(keys.get(j));
//                if(currTotal.compareTo(bill) == 0){
//                    System.out.println("getting it : " + currTotal + " bill " + bill);
//                    result.add(order);
//                    order = new ArrayList<>();
//                    continue;
//                }
//
//                if(currTotal > bill){
////                    System.out.println("Current Total exceeding " + order.toString());
//                    continue;
//                }
//
//            }
//        }
//
//        return result;
//    }
}
