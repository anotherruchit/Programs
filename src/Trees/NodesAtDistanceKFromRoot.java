package Trees;

/**
 * Created by ruchitmehta on 7/30/17.
 */
public class NodesAtDistanceKFromRoot {
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

        TreeNode n6 = new TreeNode(8);
        n4.right = n6;

        kDistanceNodes(root, 2);
    }

    static void kDistanceNodes(TreeNode node, int k){
        if(node == null)
            return;

        if(k == 0){
            System.out.print(node.data + " ");
        } else {
            kDistanceNodes(node.left, k-1);
            kDistanceNodes(node.right, k-1);
        }
    }
}
