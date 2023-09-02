/*
反转链表
206
2023-09-02 12:29:43
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
    public ListNode reverseList(ListNode head) {
        return dfs(null, head);
    }

    ListNode dfs(ListNode before, ListNode local) {
        if (local == null) {
            return before;
        }
        ListNode temp = local.next;
        local.next = before;
        return dfs(local, temp);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
