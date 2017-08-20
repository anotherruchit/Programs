package Trees;

import java.util.*;

/**
 * Created by ruchitmehta on 7/30/17.
 *
 */
public class KSumPathBTDFS {
    private static int sum = 0;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String args[]){
        TreeNode root = new TreeNode(2);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(4);
        root.left = n1;
        root.right = n2;

        // left subtree
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(6);
        n1.left = n3;
        n1.right = n4;

        TreeNode n5 = new TreeNode(2);
        n4.right = n5;

        TreeNode n6 = new TreeNode(7);
        n2.right = n6;

        printAllKSumPaths(root, 13);
        System.out.println();

    }

    public static void printAllKSumPaths(TreeNode root, int k){
        if(root == null)
            return;

        sum = sum + root.data;
        stack.push(root.data);
        if(sum == k){
            // print stack
            printStack(stack);
        }

        printAllKSumPaths(root.left, k);
        printAllKSumPaths(root.right, k);

        sum -= root.data;
        stack.pop();
    }

    static void printStack(Stack<Integer> stack){
        Iterator<Integer> it = stack.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}
