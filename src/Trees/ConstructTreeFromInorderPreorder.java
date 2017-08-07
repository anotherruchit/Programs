package Trees;

/**
 * Created by ruchitmehta on 7/29/17.
 * http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/ConstructTreeFromInOrderPreOrder.java
 * https://www.youtube.com/watch?v=LrmitUxgXbc
 */
public class ConstructTreeFromInorderPreorder {
    private static int index = 0;

    public static void main(String args[]){
        int inorder[]  = {-7,-6,-5,-4,-3,-2,1,2,3,16,6,10,11,12,14};
        int preorder[] = {3,-2,-3,-4,-5,-6,-7,1,2,16,10,6,12,11,14};
        TreeNode root = createBST(inorder, preorder, 0, inorder.length-1);
        inOrderTraversal(root);

    }

    private static void inOrderTraversal(TreeNode root){
        if(root == null)
            return;

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    private static TreeNode createBST(int[] inorder, int[] preorder, int start, int end){

        if(start > end){
            return null;
        }

        int i;
        for(i = start; i <= end; i++){
            if(inorder[i] == preorder[index])
                break;
        }

        TreeNode node = new TreeNode(preorder[index]);
        index++;
        node.left = createBST(inorder, preorder, start, i-1);
        node.right = createBST(inorder, preorder, i+1, end);
        return node;

    }

}
