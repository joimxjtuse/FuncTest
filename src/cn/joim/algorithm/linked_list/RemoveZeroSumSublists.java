package cn.joim.algorithm.linked_list;

/***
 * 1171. 从链表中删去总和值为零的连续节点
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 *
 * 删除完毕后，请你返回最终结果链表的头节点。
 *
 * 你可以返回任何满足题目要求的答案。
 *
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 *
 * 示例 1：
 *
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 * 示例 2：
 *
 * 输入：head = [1,2,3,-3,4]
 * 输出：[1,2,4]
 * 示例 3：
 *
 * 输入：head = [1,2,3,-3,-2]
 * 输出：[1]
 *
 * 提示：
 *
 * 给你的链表中可能有 1 到 1000 个节点。
 * 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * */
public class RemoveZeroSumSublists {


    public static void main(String[] args) {

//        int listArr[] = {1, 2, -3, 3, 1};
//        int listArr[] = {1, 2, 3, -3, 4};

//        int listArr[] = {5, -3, -4, 1, 6, -2, -5};
//        int listArr[] = {1, -1};
//        int listArr[] = {0, 2};
//        int listArr[] = {0, 3, -1};
        int listArr[] = {2, 1, -3, 1, 3};

        /**
         * (1, 2, 3, -3, -2)
         * (1,2,-2)
         * (1)
         * */
        ListNode head = ListNode.createListNode(listArr);

        ListNode result = new RemoveZeroSumSublists().removeZeroSumSublists(head);
        System.out.println("ok");
    }


    /***
     * 输入：head = [1,2,-3,3,1]
     *  * 输出：[3,1]
     *  * 提示：答案 [1,2,1] 也是正确的。
     *  * 示例 2：
     *  *
     *  * 输入：head = [1,2,3,-3,4]
     *  * 输出：[1,2,4]
     *  * 示例 3：
     *  *
     *  * 输入：head = [1,2,3,-3,-2]
     *  * 输出：[1]
     *
     * //[5,-3,-4,1,6,-2,-5]
     * // [5,-2,-5]
     *
     *
     *
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head, pPre = null, start = null, q = null;
        while (p != null) {

            start = p;
            q = p;
            int nCount = 0;

            while (q != null) {

                nCount += q.val;
                if (nCount != 0) {
                    q = q.next;
                } else {
                    //TODO 移除[start, q].
                    if (pPre != null) {
                        pPre.next = q.next;
                        p = pPre;
                    } else {
                        head = q.next;
                        p = head;
                        pPre = null;
                    }
                    q = null;
                }
            }
            pPre = p;
            if (p != null) {
                p = p.next;
            }
        }
        return head;
    }
}
