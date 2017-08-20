package Trees;

/**
 * Created by ruchitmehta on 8/17/17.
 * Box Interview Question
 *
 */
public class UnivalTrees {
    public static void main(String args[]){
        TreeNode root = new TreeNode(4);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(4);
        root.left = n1;
        root.right = n2;

        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(4);
        n1.left = n3;
        n1.right = n4;

        TreeNode n5 = new TreeNode(6);
        n2.left = n5;

        System.out.println(checkUnivalTrees(root));
        System.out.println(countUnivalSubtrees(root));
        System.out.println(CountUnivalSubtrees(root));
    }

    public static boolean checkUnivalTrees(TreeNode root){
        if(root == null)
            return true;

        boolean leftTree = checkUnivalTrees(root.left);
        boolean rightTree = checkUnivalTrees(root.right);

        if((root.left == null || root.left.data == root.data)
                && (root.right == null || root.right.data == root.data)
                && leftTree && rightTree){
            return true;
        }

        return false;
    }

    public static int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }

    private static boolean helper(TreeNode node, int[] count) {
        if (node == null) {
            return true;
        }
        boolean left = helper(node.left, count);
        boolean right = helper(node.right, count);
        if (left && right) {
            if (node.left != null && node.data != node.left.data) {
                return false;
            }
            if (node.right != null && node.data != node.right.data) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }


    // without using class variable
    // https://discuss.leetcode.com/topic/20721/my-concise-java-solution/3
    public static int CountUnivalSubtrees(TreeNode root)
    {
        return Math.abs(Count(root));
    }

    public static int Count(TreeNode node)
    {
        if (node == null) return 0;

        int left = Count(node.left);
        int right = Count(node.right);

        boolean isUni = left >= 0
                && right >= 0
                && (node.left == null || node.left.data == node.data)
                && (node.right == null || node.right.data == node.data);

        int val = Math.abs(left) + Math.abs(right) + (isUni ? 1 : 0);
        if (!isUni) val *= -1;

        return val;
    }
}
