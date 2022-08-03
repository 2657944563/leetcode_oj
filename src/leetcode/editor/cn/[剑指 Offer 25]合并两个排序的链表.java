/*
合并两个排序的链表
剑指 Offer 25
2022-08-01 11:38:40
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode temp = l1, head = l1;
        if (l1.val > l2.val) {
            head = l2;
            temp = l2;
            l2 = l1;
            l1 = temp;
            temp = null;
        }
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                while (l1 != null && l1.val <= l2.val) {
                    temp = l1;
                    l1 = l1.next;
                }
                if (temp != null) {
                    l1 = temp;
                }
                temp = l1.next;
                l1.next = l2;
                l2 = l2.next;
                l1 = l1.next;
                l1.next = temp;
            }
        }
        if (l2 != null) {
            l1.next = l2;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
