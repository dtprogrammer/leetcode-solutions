package dtprogrammer.github.io.p297;

import dtprogrammer.github.io.common.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Codec {

    private static String NULL_MARKER = "NN";
    private static String NODE_SEPARATOR = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(builder, root);
        return builder.toString();
    }

    private void serialize(StringBuilder builder, TreeNode root) {
        if (root == null) {
            builder.append(NULL_MARKER);
            builder.append(NODE_SEPARATOR);
            return;
        }
        builder.append(root.val);
        builder.append(NODE_SEPARATOR);
        serialize(builder, root.left);
        serialize(builder, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> splits = new LinkedList<>();
        splits.addAll(Arrays.asList(data.split(NODE_SEPARATOR)));
        return deserialize(splits);

    }

    public TreeNode deserialize(Deque<String> splits) {
        String pop = splits.pop();
        if (pop.equals(NULL_MARKER)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(pop));
            node.left = deserialize(splits);
            node.right = deserialize(splits);
            return node;
        }
    }
}
