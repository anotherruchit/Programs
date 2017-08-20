package Trees;

/**
 * Created by ruchitmehta on 8/11/17.
 * http://www.geeksforgeeks.org/find-distance-two-given-nodes/
 */
public class DistanceBetweenTwoNodes {
    static int d1 = -1;
    static int d2 = -1;
    static int distance = 0;

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

        TreeNode n5 = new TreeNode(12);
        TreeNode n6 = new TreeNode(15);
        n2.left = n5;
        n2.right = n6;

        System.out.println("Distance between the nodes is: " +minDistanceBetweenNodes(root, n2, n5));
    }

    public static int minDistanceBetweenNodes(TreeNode root, TreeNode node1, TreeNode node2){

        d1 = -1;
        d2 = -1;
        distance = 0;

        TreeNode lca = lowestCommonAncestor(root, node1, node2, 1);

        // If both n1 and n2 were present in 2 different subtrees, return dist
        if(d1 != -1 && d2 != -1)
            return distance;

        // If n1 is ancestor of n2, consider n1 as root and find level
        // of n2 in subtree rooted with n1
        if (d1 != -1){
            distance = findLevel(lca, node2, 0);
            return distance;
        }

        // If n1 is ancestor of n2, consider n1 as root and find level
        // of n2 in subtree rooted with n1
        if(d2 != -1){
            distance = findLevel(lca, node1, 0);
            return distance;
        }

        return -1;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2, int level){
        if(root == null)
            return null;

        if(root == node1){
            d1 = level;
            return root;
        }

        if(root == node2){
            d2 = level;
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, node1, node2, level+1);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2, level+1);

        if(left != null && right != null){
            distance = d1 + d2 - (2 * level);
            return root;
        }

        return (left == null) ? right : left;
    }

    public static int findLevel(TreeNode root, TreeNode node, int level){

        if(root == null)
            return -1;

        if(root == node)
            return level;

        int lev = findLevel(root.left, node, level+1);
        if(lev != -1) return lev;
        return findLevel(root.right, node, level+1);
    }


}
