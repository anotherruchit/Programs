import apple.laf.JRSUIUtils;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dharabavishi on 6/16/17.
 */
//public class InvertBinaryTree {
//    public TreeNode invertTree(TreeNode root){
//
//        // handling the edge case
//        if(root == null)
//            return null;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while(!queue.isEmpty()){
//            TreeNode current = queue.poll();
//            TreeNode temp = current.left;
//            current.left = current.right;
//            current.right = temp;
//
//            if(current.left != null)
//                queue.add(current.left);
//            if(current.right != null)
//                queue.add(current.right);
//
//        }
//
//        return root;
//    }
//}

