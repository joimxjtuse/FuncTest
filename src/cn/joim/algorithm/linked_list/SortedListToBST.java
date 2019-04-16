package cn.joim.algorithm.linked_list;

import cn.joim.algorithm.tree.TreeNode;

/**
 * 109. 有序链表转换二叉搜索树
 * <p>
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * <p>
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        } else if (head.next == null) {
            return new TreeNode(head.val);
        }
        TreeNode node = null;

        ListNode oneStepNode = head, twoStepNode = head;
        ListNode leftStart, leftEnd = null, rightStart;

        leftStart = head;

        while (oneStepNode != null && oneStepNode.next != null
                && twoStepNode != null && twoStepNode.next != null) {
            leftEnd = oneStepNode;
            oneStepNode = oneStepNode.next;

            twoStepNode = twoStepNode.next;
            if (twoStepNode != null) {
                twoStepNode = twoStepNode.next;
            }
        }

        if (oneStepNode != null) {
            rightStart = oneStepNode.next;
            node = new TreeNode(oneStepNode.val);

            node.right = createTreeFrom(rightStart);
        }

        if (leftEnd != null) {
            leftEnd.next = null;

            node.left = createTreeFrom(leftStart);
        }

        return node;
    }

    private TreeNode createTreeFrom(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            new TreeNode(head.val);
        }
        return sortedListToBST(head);

    }

    public static void main(String[] args) {

        int node[] = {-10, -3, 0, 5, 9};

        TreeNode result = new SortedListToBST().sortedListToBST(ListNode.createListNode(node));
        System.out.print("");
    }
}
