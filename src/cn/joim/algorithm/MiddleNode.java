package cn.joim.algorithm;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 * <p>
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定链表的结点数介于 1 和 100 之间。
 */
public class MiddleNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        ListNode p = head;
        ListNode node;

        node = new ListNode(2);
        p.next = node;
        p = p.next;

        node = new ListNode(3);
        p.next = node;
        p = p.next;

        node = new ListNode(4);
        p.next = node;
        p = p.next;

        node = new ListNode(5);
        p.next = node;
        p = p.next;

        node = new ListNode(6);
        p.next = node;
        p = p.next;

        MiddleNode main = new MiddleNode();
        ListNode result = main.middleNode(head);
        System.out.println(".");
    }

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p, q;
        p = head;
        q = head;

        while (q != null && q.next != null) {
            q = q.next;
            if (q != null) {
                q = q.next;
            }
            p = p.next;
        }

        return p;
    }
}
