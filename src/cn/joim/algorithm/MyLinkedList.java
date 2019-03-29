package cn.joim.algorithm;

/**
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * <p>
 * 示例：
 * <p>
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 * <p>
 * 提示：
 * <p>
 * 所有值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 */
public class MyLinkedList {

    private ListNode head;

    private int size = 0;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        ListNode p = head;

        int i = 0;
        while (i < index && p != null) {
            p = p.next;
            i++;
        }
        if (p != null) {
            return p.val;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode p = head;
        ListNode node = new ListNode(val);
        if (p != null) {
            node.next = p;
        } else {

        }
        size++;
        head = node;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode p = head;

        if (p == null) {
            addAtHead(val);
        } else {
            ListNode node = new ListNode(val);
            while (p != null & p.next != null) {
                p = p.next;
            }
            p.next = node;
            size++;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index >= 0 && index <= size) {
            if (index == size) {
                addAtTail(val);
            } else {
                int i = 0;
                ListNode p = head;
                ListNode q = null;
                while (i < index) {
                    i++;
                    q = p;
                    p = p.next;
                }

                ListNode node = new ListNode(val);
                node.next = p;
                if (q != null) {
                    q.next = node;
                } else {
                    q = node;
                    head = q;
                }
                size++;
            }
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size) {
            ListNode p = head;
            ListNode q = null;
            int i = 0;
            while (i < index) {
                i++;
                q = p;
                p = p.next;
            }

            if (q != null) {
                q.next = p.next;
            } else {
                head = head.next;
            }
            size--;
        }
    }

    public static void main(String[] args) {

        /**
         *
         * MyLinkedList linkedList = new MyLinkedList();
         *  * linkedList.addAtHead(1);
         *  * linkedList.addAtTail(3);
         *  * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
         *  * linkedList.get(1);            //返回2
         *  * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
         *  * linkedList.get(1);            //返回3
         * */
        int index = 1;
        int val = 2;

        MyLinkedList obj = new MyLinkedList();

        obj.addAtHead(1);
        obj.addAtIndex(1, 2);
        int item1 = obj.get(1);
        int item0 = obj.get(0);
        int item2 = obj.get(2);
        System.out.println(" ");
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
}
