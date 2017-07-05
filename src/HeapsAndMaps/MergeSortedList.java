package HeapsAndMaps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by dharabavishi on 6/28/17.
 * https://www.interviewbit.com/problems/merge-k-sorted-lists/
 *
 Merge k sorted linked lists and return it as one sorted list.
 Example :
 1 -> 10 -> 20
 4 -> 11 -> 13
 3 -> 8 -> 9
 will result in

 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 */
public class MergeSortedList {

    class ListNode{
        public int val;
        public ListNode next;
        public  ListNode(int x){
            next = null;
            this.val = x;
        }
    }

    public static void main(String args[]){

    }

    public ListNode mergeKLists(ArrayList<ListNode> A){

        TreeMap<Integer, ArrayList<ListNode>> treeMap = new TreeMap<>();

        ListNode node;
        ArrayList<ListNode> list;
        int val;

        if(A.size() == 0)
            return null;

        for(ListNode head : A){
            node = head;

            while(node != null){
                val = node.val;

                if(treeMap.containsKey(val)){
                    list = treeMap.get(val);
                    list.add(node);
                } else {
                    list = new ArrayList<>();
                    list.add(node);
                    treeMap.put(val, list);
                }

                node = node.next;
            }
        }

        ListNode head = null;
        node = null;

        /* Iterate over TreeMap and get each individual arraylist, traverse it and add to the final linked list */
        for(Map.Entry<Integer, ArrayList<ListNode>> entry : treeMap.entrySet()){
            list = entry.getValue();

            for(ListNode n : list){
                if(head == null){
                    head = n;
                } else {
                    node.next = n;
                }
                node = n;
            }
        }

        return  head;
    }

}
