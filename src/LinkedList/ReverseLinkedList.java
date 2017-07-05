package LinkedList;

/**
 * Created by dharabavishi on 6/20/17.
 * https://leetcode.com/articles/reverse-linked-list/
 */
public class ReverseLinkedList {

    public static void main(String args[]){
        ListNode n1 = new ListNode("1");
        ListNode n2 = new ListNode("2");
        ListNode n3 = new ListNode("3");
        ListNode n4 = new ListNode("4");
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode head = reverseLinkedList(n1);
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

    public static ListNode reverseLinkedList(ListNode head){
        if(head == null){
            return null;
        }

        ListNode prev = null, curr = head;

        while(curr != null){
            ListNode tempNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNode;
        }

        return prev;
    }
}
