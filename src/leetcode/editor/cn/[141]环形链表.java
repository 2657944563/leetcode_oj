/*
环形链表
141
2023-07-05 17:57:19
*/
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        } else if (head.val == 999999) {
            return true;
        } else {
            head.val = 999999;
            return hasCycle(head.next);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
