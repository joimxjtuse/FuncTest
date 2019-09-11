package cn.joim.algorithm.linked_list;

/**
 * 21. 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists {

    public static void main(String[] args) {

        int nL1[] = {2};
        int nL2[] = {1};
        ListNode l1, l2;
        l1 = ListNode.createListNode(nL1);
        l2 = ListNode.createListNode(nL2);

        ListNode result = new MergeTwoLists().mergeTwoLists(l1, l2);
        System.out.println("");
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode p = null, q;
        if (l1.val > l2.val) {
            p = l2;
            l2 = l2.next;
        } else {
            p = l1;
            l1 = l1.next;
        }
        q = p;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                q.next = l2;
                l2 = l2.next;
            } else {
                q.next = l1;
                l1 = l1.next;
            }
            q = q.next;
        }
        if (l1 != null) {
            q.next = l1;
        } else if (l2 != null) {
            q.next = l2;
        }
        return p;

    }
}
