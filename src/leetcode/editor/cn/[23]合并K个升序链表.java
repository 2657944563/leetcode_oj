/*
合并K个升序链表
23
2022-07-26 22:41:30
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return dg(lists, 0, lists.length - 1);
    }

    ListNode dg(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (right - left == 1) {
            //归并 left 和right
            return gb(lists[left], lists[right]);
        }
        return gb(dg(lists, left, (left + right) / 2), dg(lists, (left + right) / 2 + 1, right));
    }

    ListNode gb(ListNode left, ListNode right) {
        if (left == null && right == null) {
            return null;
        } else if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        ListNode head = left, after = null;
        if (left.val > right.val) {
            ListNode t = left;
            left = right;
            right = t;
            head = left;
        }
        while (left != null && right != null) {
            if (left.val <= right.val) {
                after = left;
                left = left.next;
            } else {
                ListNode temp = right.next;
                after.next = right;
                after = after.next;
                after.next = left;
                right = temp;
            }
        }
        if (right != null) {
            after.next = right;
        }
        return head;
    }
}
//
//class ListNode {
//    public int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}


//leetcode submit region end(Prohibit modification and deletion)
