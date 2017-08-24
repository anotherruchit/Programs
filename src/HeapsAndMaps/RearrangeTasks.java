package HeapsAndMaps;

import java.util.*;

/**
 * Created by ruchitmehta
 * https://www.careercup.com/question?id=5653760530448384 // check the other solution in RearrageStringKDistance.java
 * Ipsy Interview Question
 */
public class RearrangeTasks {
    public static void main(String[] args) {
        taskSequence("ABDCCCCBBBBA");
        taskSequence("ABBBAA");
    }

    private static void taskSequence(String input) {
        char[] arr = input.toCharArray();
        Map<String, Integer> unsortedMap = new TreeMap<String, Integer>();
        Arrays.sort(arr);

        char s = arr[0];
        int count = 1;
        int total_count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == s) {
                count++;
            } else {
                unsortedMap.put(String.valueOf(s), count);
                s = arr[i];
                count = 1;
            }
            total_count++;
        }

        if (total_count < arr.length) {
            unsortedMap.put(String.valueOf(s), count);
        }

        // this is how you sort a map
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortedMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        // System.out.println(unsortedMap);
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext();) {
            Map.Entry<String, Integer> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // System.out.println(sortedMap);

        total_count = 0;
        System.out.print("for input: " + input + " result is: ");
        while (true) {
            for (Map.Entry<String, Integer> element : sortedMap.entrySet()) {
                if (element.getValue() != 0) {
                    System.out.print(element.getKey() + "");
                    int value = element.getValue();
                    value--;
                    sortedMap.put(element.getKey(), value);
                    total_count++;
                }
            }
            if (total_count >= input.length()) {
                break;
            }
            System.out.print("_");
        }

        System.out.println();

    }
}
