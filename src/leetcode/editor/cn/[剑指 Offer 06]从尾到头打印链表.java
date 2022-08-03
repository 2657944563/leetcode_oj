/*
从尾到头打印链表
剑指 Offer 06
2022-07-31 12:39:06
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
    public int[] reversePrint(ListNode head) {
        ListNode before = null, aftere = head, temp;
        int n = 0;
        while (aftere != null) {
            temp = aftere.next;
            aftere.next = before;
            before = aftere;
            aftere = temp;
            n++;
        }
        int[] res = new int[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = before.val;
            before = before.next;
        }
        return res;
    }
}

//public class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
