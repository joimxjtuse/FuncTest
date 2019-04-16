package cn.joim.algorithm.linked_list;

public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }


    public static int length(ListNode node) {

        ListNode p = node;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        return length;

    }

    public static ListNode createListNode(int[] arr) {
        ListNode node = null;
        if (arr != null && arr.length > 0) {

            node = new ListNode(arr[0]);
            ListNode p = node;

            for (int i = 1; i < arr.length; i++) {
                ListNode item = new ListNode(arr[i]);
                p.next = item;
                p = p.next;
            }
        }
        return node;
    }
}
