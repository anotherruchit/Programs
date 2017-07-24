package Trees;

/**
 * Created by ruchitmehta
 */
public class InorderTraversal {
    public static void main(String args[]){
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(6);

        root.left = t1;
        root.right = t2;

        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        t1.right = t4;
        t1.left = t3;

        TreeNode t5 = new TreeNode(8);
        t4.left = t5;

        TreeNode t6 = new TreeNode(7);
        t2.right = t6;

        InorderTraversal traversal = new InorderTraversal();
        traversal.inOrderTraversal(root);
    }

    public void inOrderTraversal(TreeNode root){
        if(root == null)
            return;

        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }
}
