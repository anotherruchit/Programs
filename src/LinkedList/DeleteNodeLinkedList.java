package LinkedList;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by ruchitmehta
 */
public class DeleteNodeLinkedList {
    public static void main(String args[]){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode head = removeNodes(n1, 3);
        while(head != null){
            System.out.print(head.intData + " ");
            head = head.next;
        }
    }

    static ListNode removeNodes(ListNode list, int x) {
        if(list == null){
            return list;
        }

        ListNode head = list;
        ListNode curr = list, prev = null;
        while(curr != null){
            // if head value is more than x
            if(curr.intData > x){
                if(head == curr){
                    curr = curr.next;
                    head = head.next;
                } else {
                    curr = curr.next;
                    prev.next = curr;
                }

            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
