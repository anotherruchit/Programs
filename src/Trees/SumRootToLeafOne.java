package Trees;


/**
 * Created by ruchitmehta.
 *
 * NOT DONE YET
 *
 */
public class SumRootToLeafOne {
    private static final int MOD = 1003;
    private int total;
    public static void main(String args[]){

    }

    public int SumNumbers(TreeNode root){
        if(root == null)
            return 0;
        return sumRootToLeaf(root, 0) % MOD;
    }

    public int sumRootToLeaf(TreeNode root, int sum){
        if(root == null)
            return 0;

        sum = sum * 10 + root.data;

        if(root.left == null && root.right == null){
            total = total + sum;
            return total;
        }

        sumRootToLeaf(root.left, sum);
        sumRootToLeaf(root.right, sum);

        return 0;

    }
}
