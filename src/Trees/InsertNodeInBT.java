package Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ruchitmehta on 8/8/17.
 * http://javabypatel.blogspot.com/2017/05/insert-node-in-binary-tree-java.html
 */
public class InsertNodeInBT {
    private static TreeNode root;

    public static void main(String args[]){
        InsertNodeInBT tree = new InsertNodeInBT();
        tree.addNodeInBinaryTree(root, 3);
        tree.addNodeInBinaryTree(root, 4);
        tree.addNodeInBinaryTree(root, 5);
        tree.addNodeInBinaryTree(root, 6);
        tree.addNodeInBinaryTree(root, 7);
        tree.addNodeInBinaryTree(root, 8);
        tree.printLevelOrderTraversal(root);

        System.out.println("");
        tree.addNodeInBinaryTree(root, 9);
        tree.printLevelOrderTraversal(root);
    }

    private void printLevelOrderTraversal(TreeNode root) {
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(! queue.isEmpty()) {
            TreeNode curr = queue.poll();

            System.out.print(curr.data + " ");
            if(curr.left != null)
                queue.offer(curr.left);
            if(curr.right != null)
                queue.offer(curr.right);
        }
    }

    // Iterative way of adding Node to BT
    public void addNodeInBinaryTree(TreeNode root, int data){
        if(root == null){
            this.root = new TreeNode(data);
        } else {
            //Nodes present, So checking vacant position for adding new Node in sequential fashion
            //Start scanning all Levels (level by level) of a tree one by one until we found a node whose either left or right node is null.
            //For each and every node, we need to check whether Left and Right Node exist?
            //If exist, then that node is not useful for adding new node but we need to store left and right node of that node for later processing
            //that is why it is stored in Queue for sequential placement.
            //If not exist, then we found a node, where new node will be placed but not sure on left or right, so check which side is null and place new node there.

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(! queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node.left != null && node.right != null){
                    queue.add(node.left);
                    queue.add(node.right);
                } else if(node.left == null){
                    TreeNode newNode = new TreeNode(data);
                    node.left = newNode;
                    break;
                } else {
                    TreeNode newNode = new TreeNode(data);
                    node.right = newNode;
                    break;
                }
            }
        }
    }
}
