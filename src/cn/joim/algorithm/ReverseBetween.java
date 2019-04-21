package cn.joim.algorithm;

import java.util.Stack;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode p = head;

        ListNode lNode, rNode;
        lNode = p;
        rNode = p;

        ListNode lPre = null, rNext = null;

        int i = 1;
        while (i < m) {
            i++;
            lPre = lNode;
            lNode = lNode.next;
            //rNode = rNode.next;
        }
        Stack<ListNode> stack = new Stack<>();

        while (i <= n) {
            i++;
            stack.push(lNode);
            lNode = lNode.next;
        }
        rNext = lNode;

        while (!stack.isEmpty()) {
            lPre.next = stack.pop();
            lPre = lPre.next;
        }
        lPre.next = rNext;

        return head;
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(3);

        ListNode p = head;
        ListNode node;

//        node = new ListNode(2);
//        p.next = node;
//        p = p.next;
//
//        node = new ListNode(3);
//        p.next = node;
//        p = p.next;
//
//        node = new ListNode(4);
//        p.next = node;
//        p = p.next;
//
        node = new ListNode(5);
        p.next = node;
        p = p.next;

        ReverseBetween main = new ReverseBetween();
        ListNode result = main.reverseBetween(head, 1, 2);
        System.out.println("");
    }
}
