package dtprogrammer.github.io.p297;

import dtprogrammer.github.io.common.TreeNode;
import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(9);
        String serialize = codec.serialize(root);
        System.out.println(serialize);

        TreeNode deserialize = codec.deserialize(serialize);
    }
}
