package LinkedList;

import java.util.ArrayList;

/**
 * Created by ruchitmehta
 */
public class PalindromeLinkedList {

    public static void main(String args[]){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode head = isPalindrome(n1);
        printLinkedList(head);
    }

    static ListNode isPalindrome(ListNode head){
        ListNode slowPtr = head, fastPtr = head;
        ListNode prevToSlowPtr = head;
        ListNode midNode = null;
        ListNode secondHalfHead = null;

        /* Get the middle of the list. Move slow_ptr by 1
               and fast_ptrr by 2, slow_ptr will have the middle
               node */
        while(fastPtr != null && fastPtr.next != null){
            /*We need previous of the slow_ptr for
                  linked lists  with odd elements */
            prevToSlowPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        // if the linkedlist is of odd size then ignore the midNode
        if(fastPtr == null){ // list of odd size
            secondHalfHead = slowPtr.next;
        } else {
            midNode = slowPtr.next;
            secondHalfHead = midNode.next;
        }

        // reverse the second half
        secondHalfHead = reverseLinkedList(secondHalfHead);

        System.out.println(compareLinkedList(head, secondHalfHead));

        secondHalfHead = reverseLinkedList(secondHalfHead);

        // if midnode exists i.e. list of odd size
        if(midNode != null){
            slowPtr.next = midNode;
            midNode.next = secondHalfHead;
        } else {
            // list of even size
            slowPtr.next = secondHalfHead;
        }


        return head;


    }

     static void printLinkedList(ListNode head){
        if(head == null)
            return;
        while(head != null){
            System.out.print(head.intData + " ");
            head = head.next;
        }
    }

    static boolean compareLinkedList(ListNode head1, ListNode head2){

        if(head1 == null || head2 == null)
            return false;
        System.out.println(head1.intData + " " + head2.intData);
        while(head1 != null || head2 != null){
            if(head1.intData == head2.intData){
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        if(head1 == null && head2 == null){
            return true;
        }
        System.out.println("returning from here ");
        return false;
    }


    static ListNode reverseLinkedList(ListNode head){
        if(head == null)
            return null;

        ListNode prev = null, curr, next;
        curr = head;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
