package cn.joim.algorithm.linked_list;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/sort-list/
 * <p>
 * 148. 排序链表
 * <p>
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortList {

    public static void main(String[] args) {

        //int array[] = {-1, 5, 3, 4, 0};
        int array[] = {4, 2, 1, 3};
        ListNode listNode = ListNode.createListNode(array);

        System.out.println("ok.");
    }

    /**
     * O(nlogn)
     * <p>
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     * <p>
     * (4->2),(1->3)
     *
     * <p>
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     */
    public ListNode sortList(ListNode head) {

        if (head == null) {
            return null;
        }
        //step-1. 找到head中间节点,划分为left & right;

        //*** 一定得断开 left和right.
        ListNode left = head, right = left.next, pre = left;
        while (left != null && right != null) {

            pre = left;
            left = left.next;
            right = right.next;
            if (right != null) {
                right = right.next;
            }
        }
        if (pre != null && left != null) {
            pre.next = null;
            right = left;
            left = head;
        }
        //step-2. 对left和right分别走step-1,直到left.next和right.next为空，
        //        对left和right进行排序

        if (left.next != null) {
            left = sortList(left);
        }
        if (right.next != null) {
            right = sortList(right);
        }
        return maerge(left, right);
    }

    private ListNode maerge(ListNode left, ListNode right) {

        ListNode head = null;

        if (left == null) {
            head = right;
            right = right.next;
        } else if (right == null) {
            head = left;
            left = left.next;
        } else if (left.val < right.val) {
            head = left;
            left = left.next;
        } else {
            head = right;
            right = right.next;
        }
        ListNode p = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }

        if (left != null) {
            p.next = left;
        } else if (right != null) {
            p.next = right;
        }

        return head;

    }

}