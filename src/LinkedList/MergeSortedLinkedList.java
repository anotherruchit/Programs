package LinkedList;

/**
 * Created by ruchitmehta
 */
public class MergeSortedLinkedList {

    public static void main(String args[]){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(8);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode head = mergeSortedLists(n1, l1);
        while(head != null){
            System.out.println(head.intData);
            head = head.next;
        }
    }

    public static ListNode mergeSortedLists(ListNode l1, ListNode l2){

        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        ListNode mergeHead = new ListNode(0);
        ListNode head;
        head = mergeHead;

        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                if(l1.intData < l2.intData){
                    head.next = l1;

                } else {
                    head.next = l2;
                }
                head = head.next;
            }

        }
        return mergeHead.next;
    }
}
