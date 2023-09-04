/*
K 个一组翻转链表
25
2023-09-04 21:33:07
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head, res;
        if (k == 1 || head == null) {
            return head;
        }
        for (int i = 0; i < k - 1; i++) {
            if (head.next == null) {
                return temp;
            }
            head = head.next;
        }
        res = head.next;
        head.next = null;
        reverseList(temp);
        temp.next = reverseKGroup(res, k);
        return head;
    }


    ListNode reverseList(ListNode head) {
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
