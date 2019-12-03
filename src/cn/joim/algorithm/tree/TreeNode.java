package cn.joim.algorithm.tree;

import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }


    public static TreeNode createTreeFrom(Integer arrays[]) {
        TreeNode head = null;
        if (arrays != null && arrays.length > 0 && arrays[0] != null) {

            Stack<TreeNode> stack = new Stack<>();
            head = new TreeNode(arrays[0]);
            stack.push(head);
            for (int i = 0; i < arrays.length; i += 2) {
                TreeNode left, right;
                TreeNode node = stack.pop();

                left = new TreeNode(arrays[i]);
                node.left = left;
                if (left != null) {
                    stack.push(left);
                }

                if (i + 1 < arrays.length) {
                    right = new TreeNode(arrays[i + 1]);
                    node.right = right;
                    if (right != null) {
                        stack.push(right);
                    }
                }
            }
        }

        return head;
    }
}