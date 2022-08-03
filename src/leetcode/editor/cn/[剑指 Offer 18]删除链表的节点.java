/*
删除链表的节点
剑指 Offer 18
2022-07-31 21:31:21
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
    public ListNode deleteNode(ListNode head, int val) {
        if (head != null && head.val == val) {
            return head.next;
        }
        ListNode l = head, before = null;
        while (head != null) {
            if (head.val == val) {
                before.next = head.next;
            }
            before = head;
            head = head.next;
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
