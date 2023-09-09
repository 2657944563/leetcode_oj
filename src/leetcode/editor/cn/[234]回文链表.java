/*
回文链表
234
2023-09-09 19:51:19
*/
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

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
    public boolean isPalindrome(ListNode head) {
        ListNode per = head;
        if (head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        while (per != null && per.next != null) {
            stack.push(head.val);
            head = head.next;
            per = per.next.next;
        }
        if (per == null) {
            while (!stack.isEmpty()) {
                if (head == null || !stack.pop().equals(head.val)) {
                    return false;
                }
                head = head.next;
            }
        } else {
            head = head.next;
            while (!stack.isEmpty()) {
                if (head == null || !stack.pop().equals(head.val)) {
                    return false;
                }
                head = head.next;
            }
        }
        return true;
    }

//    class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
