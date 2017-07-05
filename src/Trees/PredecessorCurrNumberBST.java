package Trees;

/**
 * Created by ruchitmehta.
 * https://discuss.leetcode.com/topic/25076/share-my-java-recursive-solution
 */
public class PredecessorCurrNumberBST {
    TreeNode root;

    public static void main(String args[]){
        PredecessorCurrNumberBST tree = new PredecessorCurrNumberBST();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(15);
        tree.root.left.left = new TreeNode(6);
        tree.root.left.right = new TreeNode(9);
        tree.root.right.left = new TreeNode(13);
        tree.root.right.right = new TreeNode(18);
        TreeNode n1 = new TreeNode(12);
        TreeNode n2 = new TreeNode(14);
        tree.root.right.left.left = n1;
        tree.root.right.left.right = n2;

        TreeNode target = new TreeNode(9);
        System.out.println(tree.inOrderPredecessor(tree.root, target).data);

        target = new TreeNode(13);
        System.out.println(tree.inOrderPredecessor(tree.root, target).data);
    }

    public TreeNode inOrderPredecessor(TreeNode root, TreeNode target){
        if(root == null)
            return null;

        if (root == null)
            return null;

        if (root.data >= target.data) {
            return inOrderPredecessor(root.left, target);
        } else {
            TreeNode right = inOrderPredecessor(root.right, target);
            return (right != null) ? right : root;
        }
    }
}
