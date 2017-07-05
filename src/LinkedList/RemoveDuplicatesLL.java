package LinkedList;

/**
 * Created by dharabavishi on 6/21/17.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/#/description
 */
public class RemoveDuplicatesLL {

    public static void main(String args[]){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode head = removeDuplicates(n1);
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

    public static ListNode removeDuplicates(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode curr = head;
        ListNode pre = fakeHead;

        while(curr != null){
            while(curr.next != null && curr.intData == curr.next.intData){
                curr = curr.next;
            }

            if(pre.next == curr){
                pre = pre.next;
            } else {
                pre.next = curr.next;
            }

            curr = curr.next;
        }

        return fakeHead.next;
    }
}
