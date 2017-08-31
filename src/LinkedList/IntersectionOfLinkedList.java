package LinkedList;

/**
 * Created by ruchitmehta on 8/30/17.
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * TODO:
 */
public class IntersectionOfLinkedList {

    public static void main(String args[]){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        l1.next = l2;
        l2.next = n3;

        System.out.println(getIntersectionNode(n1, l1).data);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private static int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
}
