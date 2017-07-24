package LinkedList;

import java.util.List;

/**
 * Created by ruchitmehta
 * http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
 */
public class DetectAndRemoveLoop {
    public static void main(String args[]){
        ListNode n1 = new ListNode(10);
        ListNode n2 = new ListNode(20);
        ListNode n3 = new ListNode(30);
        ListNode n4 = new ListNode(40);
        ListNode n5 = new ListNode(50);
        ListNode n6 = new ListNode(60);
        ListNode n7 = new ListNode(70);
        ListNode n8 = new ListNode(80);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n6;

        DetectAndRemoveLoop list = new DetectAndRemoveLoop();
//        list.printList(n1);
        System.out.println(list.detectAndRemoveLoop(n1));
        list.printList(n1);
    }

    public int detectAndRemoveLoop(ListNode head){
        ListNode slow = head, fast = head;
        while(slow.next != null || fast != null || fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                // call removeLoop() method
              removeLoop(slow, head);
                return 1;
            }
        }
        return 0;
    }

    public void removeLoop(ListNode slow, ListNode head){


        //until they meet at the head of the node
        // move pointer 2 to find the end of the loop
        // set null for pointer2

        ListNode ptr1, ptr2;
        int loopLength = 1;

        // find the length of the loop
        ptr1 = slow;
        ptr2 = slow;

        // find length of the loop
        while(ptr2.next != ptr1){
            ptr2 = ptr2.next;
            loopLength++;
        }
        System.out.println("Length of the loop: " + loopLength);

        // keep distance k between 2 pointers
        ptr1 = head;
        ptr2 = head;
        for(int i = 0; i < loopLength; i++){
            ptr2 = ptr2.next;
        }

        // move both the pointers at same space until they meet at loop's starting node
        while(ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // Get pointer to the last node
        while(ptr2.next != ptr1){
            ptr2 = ptr2.next;
        }

        // break the loop
        ptr2.next = null;
    }

    // Function to print the linked list
    void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.intData + " ");
            node = node.next;
        }
    }

}
