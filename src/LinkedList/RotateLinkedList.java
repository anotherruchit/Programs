package LinkedList;

import LinkedList.ListNode;

/**
 * Created by dharabavishi on 6/21/17.
 * https://leetcode.com/problems/rotate-list/#/description
 */
public class RotateLinkedList {

    public static void main(String args[]){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode head = rotateList(n1, 9);
        printLinkedList(head);
    }

    public static void printLinkedList(ListNode head){
        if(head == null)
            return;
        while(head != null){
            System.out.print(head.intData + " ");
            head = head.next;
        }
    }

    public static ListNode rotateList(ListNode head, int k){

        if(head == null || head.next == null)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy, fast = dummy;
        dummy.next = head;
        int length = 0;

        while(fast.next != null){
            length++;
            fast = fast.next;
        }

        for(int j = length - k % length; j > 0 ; j--){
            slow = slow.next;
        }

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }
}
