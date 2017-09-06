package HeapsAndMaps;

import java.util.*;

/**
 * Created by ruchitmehta
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

    /**
     * Time Complexity : log(k) * n.
     * k is number of list and n is number of total elements
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });

        ListNode head = new ListNode(0);
        ListNode p = head;

        for(ListNode list: lists){
            if(list!=null)
                queue.offer(list);
        }

        while(!queue.isEmpty()){
            ListNode n = queue.poll();
            p.next = n;
            p = p.next;

            if(n.next != null)
                queue.offer(n.next);
        }

        return head.next;
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
