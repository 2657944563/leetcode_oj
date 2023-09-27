// 开始时间：2023-09-27 11:16:09
// 题目标题：分隔链表
// 题目标记：partition-list
// 题目编号：86
// 题目描述：
/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 * <p>
 * <p>
 * Related Topics 链表 双指针 👍 759 👎 0
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
    public ListNode partition(ListNode head, int x) {
        ListNode temp1Root = null;
        ListNode temp1Last = new ListNode();
        ListNode temp2Root = null;
        ListNode temp2Last = new ListNode();
        while (head != null) {
            if (head.val < x) {
                if (temp1Root == null) {
                    temp1Root = new ListNode(head.val);
                    temp1Last = temp1Root;
                } else {
                    temp1Last.next = new ListNode(head.val);
                    temp1Last = temp1Last.next;
                }
            } else {
                if (temp2Root == null) {
                    temp2Root = new ListNode(head.val);
                    temp2Last = temp2Root;
                } else {
                    temp2Last.next = new ListNode(head.val);
                    temp2Last = temp2Last.next;
                }
            }
            head = head.next;
        }
        temp1Last.next = temp2Root;
        return temp1Root == null ? temp2Root : temp1Root;
    }
}
//
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

