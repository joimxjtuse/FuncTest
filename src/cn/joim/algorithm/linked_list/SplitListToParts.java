package cn.joim.algorithm.linked_list;

import java.util.Arrays;

/**
 * 725. 分隔链表
 * <p>
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 * <p>
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 * <p>
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 * <p>
 * 返回一个符合上述规则的链表的列表。
 * <p>
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * root = [1, 2, 3], k = 5
 * 输出: [[1],[2],[3],[],[]]
 * 解释:
 * 输入输出各部分都应该是链表，而不是数组。
 * 例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
 * 第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
 * 最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
 * 示例 2：
 * <p>
 * 输入:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * 解释:
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
 * <p>
 * <p>
 * 提示:
 * <p>
 * root 的长度范围： [0, 1000].
 * 输入的每个节点的大小范围：[0, 999].
 * k 的取值范围： [1, 50].
 */
public class SplitListToParts {

    public ListNode[] splitListToParts(ListNode root, int k) {
        if (k <= 0) {
            return null;
        }
        ListNode result[] = new ListNode[k];
        int length = length(root);
        /**
         * length = 11, k = 3
         *
         *
         * 11 / 3 = 3, 11 % 3 = 2
         *
         * */
        int minItemLength = Math.max(1, length / k);

        int added = length > k ? length % k : 0;


        for (int i = 0; i < k; i++) {

            ListNode item = root;
            int itemCount = minItemLength + (added > 0 ? 1 : 0);
            added = Math.max(0, (added - 1));

            while (root != null && itemCount != 1) {
                itemCount--;
                root = root.next;
            }
            if (root != null) {
                ListNode pre = root;
                root = root.next;
                pre.next = null;

            }

            result[i] = item;
        }
        return result;
    }

    private int length(ListNode node) {
        ListNode p = node;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        return length;
    }

    public static void main(String[] args) {

        int liatArray[] = {};
        int k = 3;
        ListNode[] result = new SplitListToParts()
                .splitListToParts(ListNode.createListNode(liatArray), k);
        System.out.println();

    }
}
