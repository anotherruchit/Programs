package LinkedList;

/**
 * Created by dharabavishi on 6/18/17.
 * Find the middle element of the linkedlist
 */
public class LinkedListMiddleElement {

    public static void main(String args[]){
        ListNode n1 = new ListNode("1");
        ListNode n2 = new ListNode("2");
        ListNode n3 = new ListNode("3");
        ListNode n4 = new ListNode("4");
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        findMiddleElement(n1);
    }

    public static void findMiddleElement(ListNode head){

        if(head != null || head.next != null){
            ListNode current = head, middle = head;
            int length = 1;

            while (current.next != null) {
                length++;
                if (length % 2 == 0){
                    middle = middle.next;
                }
                current = current.next;
            }

            if(length % 2 == 1){
                middle = middle.next;
            }

            System.out.println("length of LinkedList.LinkedList: " + length);
            System.out.println("middle element of LinkedList.LinkedList : " + middle);
        }
    }
}

