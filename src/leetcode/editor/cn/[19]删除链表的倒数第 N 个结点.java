/*
删除链表的倒数第 N 个结点
19
2023-07-07 17:21:30
*/
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode right = head;
        ListNode left = null;
        for (int i = 0; i < n - 1; i++) {
            right = right.next;
        }
        while (right.next != null) {
            left = left == null ? head : left.next;
            right = right.next;
        }
        if (left == null) {
            return head.next;
        } else {
            left.next = left.next.next;
        }

        return head;
    }
}

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
