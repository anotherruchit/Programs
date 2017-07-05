package LinkedList;

/**
 * Created by dharabavishi on 6/20/17.
 * https://leetcode.com/problems/reverse-linked-list-ii/#/solutions
 */
public class ReverseBetweenLinkedList {

    public static void main(String args[]){
        ListNode n1 = new ListNode("1");
        ListNode n2 = new ListNode("2");
        ListNode n3 = new ListNode("3");
        ListNode n4 = new ListNode("4");
        ListNode n5 = new ListNode("5");
        ListNode n6 = new ListNode("6");
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode head = reverseBetween(n1, 2, 4);
        printLinkedList(head);
    }

    public static void printLinkedList(ListNode head){
        if(head == null)
            return;
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n){

        ListNode dummy = new ListNode("0"); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy;  // make a pointer pre as a marker for the node before reversing

        for(int i = 0 ; i < m-1 ; i++){
            pre = pre.next;
        }

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for(int i = 0 ; i < n-m ; i++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return pre;

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
    }
}
