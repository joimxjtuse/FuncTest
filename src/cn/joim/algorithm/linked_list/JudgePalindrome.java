package cn.joim.algorithm.linked_list;

import java.util.Stack;

/**
 * 234. 回文链表
 * <p>
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class JudgePalindrome {

    public boolean isPalindrome(ListNode head) {

//        return isPalindromeDefaultImpl(head);
        return isPalindromeBetterImpl(head);
    }

    private static boolean isPalindromeDefaultImpl(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }
        //第一次遍历： 计算链表长度,获取中间节点.
        int nLength = length(head);
        //第二次遍历，找到中间节点，并将左侧节点入栈
        ListNode middleNode = head;
        Stack<ListNode> stack = new Stack<>();
        //1->2->2->1
        //1->2->3->2->1
        for (int i = 0; i < nLength / 2; i++) {
            stack.push(middleNode);
            middleNode = middleNode.next;
        }
        if (nLength % 2 == 1 && !stack.isEmpty()) {
            //长度基数时，栈顶元素出栈。
            //stack.pop();
            middleNode = middleNode.next;
        }
        boolean result = false;
        while (middleNode != null && !stack.isEmpty()) {
            if (middleNode.val == stack.pop().val) {
                result = true;
            } else {
                result = false;
                break;
            }
            middleNode = middleNode.next;
        }


        return result;
    }

    /**
     * 统计下，在1.5n的遍历次数后可以判断是否为回文，平均时间复杂度为O(n),空间复杂度为O(1).
     */
    private static boolean isPalindromeBetterImpl(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int nLength = length(head);
        //1->2->2->1
        //1->2->3->2->1
        //第一步，找到中间节点及其前一item，断开链表；
        //1->2 2->1
        //1->2->3 2->1
        ListNode low = head, preLow = null, quick = head;
        while (low != null && quick != null && quick.next != null && quick.next.next != null) {
            quick = quick.next.next;
            preLow = low;
            low = low.next;
        }

        //第二步，反转左侧链表，
        //2->1 2->1
        //2-> 3->2->1
        ListNode left = head, right = low.next;
        if (low != null) {
            low.next = null;
        }

        ListNode p = null, q;
        while (left != null) {
            q = left.next;
            left.next = p;
            p = left;
            left = q;
            //q.next = p;
        }
        boolean result = false;
        //计算链表长度，如果链表长度为基数，则快进一个节点；

        if (nLength % 2 == 1) {
            p = p.next;
        }
        left = p;
        while (left != null && right != null) {
            if (left.val == right.val) {
                result = true;
            } else {
                result = false;
                break;
            }
            left = left.next;
            right = right.next;
        }

        //判断两个链表是否相等。

        return result;
    }

    private static int length(ListNode head) {
        ListNode p = head;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        return length;
    }

    public static void main(String[] args) {

        int array[] = {1, 2, 2, 1};
        new JudgePalindrome().isPalindrome(ListNode.createListNode(array));
    }


}
