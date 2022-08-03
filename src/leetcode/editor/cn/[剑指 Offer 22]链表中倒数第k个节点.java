/*
链表中倒数第k个节点
剑指 Offer 22
2022-08-01 11:26:26
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
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode before = head;
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            before = before.next;
        }
        return before;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
