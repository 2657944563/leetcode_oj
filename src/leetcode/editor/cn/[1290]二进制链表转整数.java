// 开始时间：2023-10-25 21:46:35
// 题目标题：二进制链表转整数
// 题目标记：convert-binary-number-in-a-linked-list-to-integer
// 题目编号：1290
// 题目描述：
/**
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * <p>
 * 请你返回该链表所表示数字的 十进制值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [0]
 * 输出：0
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：1
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * 输入：head = [0,0]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。
 * <p>
 * <p>
 * Related Topics 链表 数学 👍 153 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)

//import cn.collection.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int sum = 0;
        while (head != null && head.val == 0) {
            head = head.next;
        }
        while (head != null) {
            System.out.println(head.val);
            sum = sum * 2 + head.val;
            head = head.next;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

