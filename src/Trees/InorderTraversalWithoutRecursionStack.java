package Trees;

/**
 * Created by ruchitmehta.
 * https://www.youtube.com/watch?v=wGXB9OWhPTg
 * http://www.programcreek.com/2014/05/leetcode-inorder-successor-in-bst-java/
 *
 * Inorder Traversal without using stack and recursion
 *
 */
public class InorderTraversalWithoutRecursionStack {

    TreeNode root;

    public static void main(String args[]){
        InorderTraversalWithoutRecursionStack tree = new InorderTraversalWithoutRecursionStack();
        tree.root = new TreeNode(5);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(6);
        tree.root.left.left = new TreeNode(2);
        tree.root.left.right = new TreeNode(4);
        tree.root.right.right = new TreeNode(7);

        tree.inorderTraversal(tree.root);
    }

    public void inorderTraversal(TreeNode root){
        TreeNode current, pre;

        if(root == null)
            return;

        current = root;
        while(current != null){
            if(current.left == null){
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                pre = current.left;

                while(pre.right != null && pre.right != current)
                    pre = pre.right;

                if(pre.right == null){
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }
}
