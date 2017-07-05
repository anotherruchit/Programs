package Trees;

/**
 * Created by ruchitmehta.
 * https://www.interviewbit.com/problems/next-greater-number-bst/
 * https://www.youtube.com/watch?v=5cPbNCrdotA&feature=player_embedded
 */
public class NextGreaterNumberBST {
    TreeNode root;

    public static void main(String args[]){
        NextGreaterNumberBST tree = new NextGreaterNumberBST();
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
        System.out.println(tree.inOrderSuccessor(tree.root, target).data);

        target = new TreeNode(13);
        System.out.println(tree.inOrderSuccessor(tree.root, target).data);
    }

    public TreeNode inOrderSuccessor(TreeNode root, TreeNode target){
        if(root == null)
            return null;

        TreeNode next = null;
        TreeNode curr;
        curr = root;
        while(curr != null && curr.data != target.data){
            if(target.data < curr.data){
                next = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        if(curr == null)
            return null;

        if(curr.right == null)
            return next;
        else {
            curr = curr.right;
            while(curr.left != null){
                curr = curr.left;
            }
        }

        return  curr;
    }
}
