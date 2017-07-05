package Trees;

/**
 * Created by ruchitmehta.
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/#/description
 * http://www.programcreek.com/2013/01/leetcode-convert-sorted-list-to-binary-search-tree-java/
 */
public class SortedListToBST {
    ListNode h;

    public static void main(String args[]){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(4);
        n3.next  = n4;
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        ListNode n6 = new ListNode(6);
        n5.next = n6;
        ListNode n7 = new ListNode(7);
        n6.next = n7;

        SortedListToBST tree = new SortedListToBST();
        System.out.println(tree.sortedListToBST(n1).data);
    }

    public TreeNode sortedListToBST(ListNode head){
        if(head == null){
            return null;
        }
        h = head;
        int len = getLinkedListLength(h);
        return toBST(0, len-1);
    }

    public int getLinkedListLength(ListNode head) {
        int len = 0;
        ListNode p = head;

        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }

    // build tree bottom-up
    public TreeNode toBST(int start, int end) {
        if (start > end)
            return null;

        // mid
        int mid = (start + end) / 2;

        TreeNode left = toBST(start, mid - 1);
        TreeNode root = new TreeNode(h.data);
        h = h.next;
        TreeNode right = toBST(mid + 1, end);

        root.left = left;
        root.right = right;

        return root;
    }
}
