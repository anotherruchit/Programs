package Trees;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by ruchitmehta.
 */
public class SerializeDeserializeBinaryTree {
    private static final String spliter = ",";
    private static final String NN = "X";

    public static void main(String args[]){
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(6);
        root.left = t1;
        root.right = t2;

        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(12);
        t1.left = t3;
        t1.right = t4;

        TreeNode t5 = new TreeNode(13);
        t4.left = t5;

        TreeNode t6 = new TreeNode(15);
        t2.right = t6;

        SerializeDeserializeBinaryTree tree = new SerializeDeserializeBinaryTree();
        String serialize = tree.serialize(root);
        System.out.println("Serialized Binary Tree: " + serialize);

        tree.deserialize(serialize);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.data).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        System.out.println("Currently Processing: " + val);
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
