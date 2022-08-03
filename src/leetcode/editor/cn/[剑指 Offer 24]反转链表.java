/*
反转链表
剑指 Offer 24
2022-08-01 11:34:18
*/
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode before = null, after = head, temp;
        if (before == null && head != null) {
            before = head;
            after = head.next;
            before.next = null;
        }
        while (after != null) {
            temp = after;
            after = after.next;
            temp.next = before;
            before = temp;
        }
        return before;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
