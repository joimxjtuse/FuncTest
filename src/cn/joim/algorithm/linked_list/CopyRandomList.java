package cn.joim.algorithm.linked_list;

/***
 * 138. 复制带随机指针的链表
 *
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深拷贝。
 *
 *
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * */
public class CopyRandomList {

    private static class Node {

        int val;
        Node next;
        Node random;

    }

    public static void main(String[] args) {

        Node head = null;


        //{"$id":"1","next":null,"random":null,"val":-1}

        /*Node a2 = new Node();
        a2.val = 2;
        a2.next = null;
        a2.random = a2;

        Node a1 = new Node();
        a1.val = 1;
        a1.next = a2;
        a1.random = a2;
        head = a1;*/

        Node a1 = new Node();
        a1.val = -1;
        a1.next = null;
        a1.random = null;

        head = a1;

        Node result = new CopyRandomList().copyRandomList(head);
        System.out.println("ok.");
    }

    /**
     * 思路分析：
     * <p>
     * 给定一个单链表: a -> b -> c -> d;
     * step 1. 在每一个节点X之间添加一个X'，其random节点指向原节点的random节点：
     * a -> a' -> b -> b' -> c -> c' -> d -> d';
     * step 2. a'节点的random节点的next即为a'.random的最终位置；
     * step 3. 遍历原节点，使得：
     * a -> b -> c -> d,
     * a' -> b' -> c' -> d'.
     */
    public Node copyRandomList(Node head) {

        //Next pointer of node with val 1 from the original list was modified.
        //原始列表不能更改吗.
        if (head == null) {
            return head;
        }
        Node p = head, result = null;
        // head： a -> b -> c -> d

        // 1. 链表拷贝. a -> a' -> b -> b' -> c ->c' -> d ->d'
        while (p != null) {
            Node node = new Node();
            node.val = p.val;

            node.next = p.next;
            p.next = node;

            node.random = p.random;

            p = node.next;
        }
        //2. a'random = a'.randon.next ;
        int nStart = 1;
        p = head;
        while (p != null) {
            if (nStart % 2 == 0) {
                if (p.random != null) {
                    p.random = p.random.next;
                }
            }
            nStart++;
            p = p.next;
        }
        //3. 移除奇数位置的节点.
        result = head.next;
        p = head;

        while (p != null) {
            Node temp = p.next;

            if (p.next != null) {
                p.next = p.next.next;
            }
            p = temp;
        }
        return result;
    }
}
