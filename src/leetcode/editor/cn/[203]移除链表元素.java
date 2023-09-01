/*
移除链表元素
203
2023-09-01 17:52:15
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode root = getRoot(head, val);
        head = root;
        while (root != null) {
            root.next = getRoot(root.next, val);
            root = root.next;
        }
        return head;

    }

    ListNode getRoot(ListNode head, int val) {
        while (head != null) {
            if (head.val == val) {
                head = head.next;
            } else {
                return head;
            }
        }
        return null;
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
