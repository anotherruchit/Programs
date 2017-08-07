package Trees;

/**
 * Created by ruchitmehta on 7/31/17.
 * http://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/
 */
public class KthLargestElementBST {
    public static int index = 0;
    public static void main(String args[]){
        TreeNode root = new TreeNode(6);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(7);
        root.left = n1;
        root.right = n2;

        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(5);
        n1.left = n3;
        n1.right = n4;

        TreeNode n5 = new TreeNode(9);
        n2.right = n5;

        kthLargestElement(root, 2);

    }

    static void kthLargestElement(TreeNode root, int k){

        // Base cases, the second condition is important to
        // avoid unnecessary recursive calls
        if(root == null || index >= k)
            return;

        // Follow reverse inorder traversal so that the
        // largest element is visited first
        kthLargestElement(root.right, k);

        // Increment count of visited nodes
        index++;

        if(index == k){
            System.out.println(" ** kth largest element is  " + root.data);
            return;
        }

        kthLargestElement(root.left, k);
    }
}
