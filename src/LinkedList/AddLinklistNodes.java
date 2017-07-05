package LinkedList;

import java.util.*;

/**
 * Created by dharabavishi on 6/19/17.
 *
 * https://leetcode.com/problems/add-two-numbers-ii/#/solutions
 */

public class AddLinklistNodes {

    // Function to add corresponding elements of the linked list
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while(l1 != null) {
            s1.push(l1.intData);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.intData);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            list.intData = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }

        return list.intData == 0 ? list.next : list;
    }

//    /* Inserts a new Node at front of the list. */
//    public void push(int new_data)
//    {
//        /* 1 & 2: Allocate the Node &
//                  Put in the data*/
//        LinkedList.LinkedList.NewLinkedList new_node = new LinkedList.LinkedList.NewLinkedList(new_data);
//
//        /* 3. Make next of new Node as head */
//        new_node.next = head;
//
//        /* 4. Move the head to point to new Node */
//        head = new_node;
//    }

    public static void main(String args[]){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode m1 = new ListNode(5);
        ListNode m2 = new ListNode(7);
        ListNode m3 = new ListNode(4);
        ListNode m4 = new ListNode(9);

        m1.next = m2;
        m2.next = m3;
        m3.next = m4;

        ListNode head = addTwoNumbers(n1, m1);

        while(head != null){
            System.out.print(head.intData + " -> ");
            head = head.next;
        }


    }
}


//
//
