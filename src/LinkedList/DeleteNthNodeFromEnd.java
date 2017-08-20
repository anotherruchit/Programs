package LinkedList;

/**
 * Created by ruchitmehta on 8/13/17.
 * http://www.programcreek.com/2014/05/leetcode-remove-nth-node-from-end-of-list-java/
 */
public class DeleteNthNodeFromEnd {

    public static void main(String args[]){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(6);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode head = removeNthNodeFromEnd(n1, 3);
        while(head != null){
            System.out.print(head.intData + " ");
            head = head.next;
        }
    }

    public static ListNode removeNthNodeFromEnd(ListNode head, int n){
        if(head == null)
            return null;

        ListNode slow = head, fast = head;
        for(int i = 1; i < n; i++){
            fast = fast.next;
        }

        if(fast == null){
            head = head.next;
            return head;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;

    }
}
