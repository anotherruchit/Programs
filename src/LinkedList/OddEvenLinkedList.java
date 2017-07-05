package LinkedList;

/**
 * Created by dharabavishi on 6/20/17.
 * https://leetcode.com/articles/odd-even-linked-list/
 */
public class OddEvenLinkedList {

    public static void main(String args[]){
        ListNode n1 = new ListNode("1");
        ListNode n2 = new ListNode("2");
        ListNode n3 = new ListNode("3");
        ListNode n4 = new ListNode("4");
        ListNode n5 = new ListNode("5");

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode newHead = getOddEvenLinkedList(n1);
        while(newHead != null){
                System.out.print(newHead.data + " ");
                newHead = newHead.next;
            }
    }

    public static ListNode getOddEvenLinkedList(ListNode head){
        if(head == null)
            return null;
        ListNode odd = head, even = head.next, evenhead = even;

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenhead;
        return  head;
    }

}
