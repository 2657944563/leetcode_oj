package cn.collection;

/**
 * @author 呙启伟
 * @date 2023/10/25 22:01
 */

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
