/*
相交链表
160
2023-07-05 18:12:54
*/
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aSum = 0;
        int bSum = 0;
        ListNode headAA = headA;
        ListNode headBB = headB;
        while (headAA != null) {
            ++aSum;
            headAA = headAA.next;
        }
        while (headBB != null) {
            ++bSum;
            headBB = headBB.next;
        }
        if (aSum == bSum) {
            return getRes(headA, headB);
        } else if (aSum < bSum) {
            int n = bSum - aSum;
            for (int i = 0; i < n; i++) {
                headB = headB.next;
            }
            return getRes(headA, headB);

        } else {
            int n = aSum - bSum;
            for (int i = 0; i < n; i++) {
                headA = headA.next;
            }
            return getRes(headA, headB);
        }
    }

    ListNode getRes(ListNode headA, ListNode headB) {
        while (headA != null || headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
