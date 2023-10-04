// 开始时间：2023-10-04 15:34:46
// 题目标题：二进制表示中质数个计算置位
// 题目标记：prime-number-of-set-bits-in-binary-representation
// 题目编号：762
// 题目描述：

/**
 * 给你两个整数 left 和 right ，在闭区间 [left, right] 范围内，统计并返回 计算置位位数为质数 的整数个数。
 * <p>
 * 计算置位位数 就是二进制表示中 1 的个数。
 * <p>
 * <p>
 * 例如， 21 的二进制表示 10101 有 3 个计算置位。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：left = 6, right = 10
 * 输出：4
 * 解释：
 * 6 -> 110 (2 个计算置位，2 是质数)
 * 7 -> 111 (3 个计算置位，3 是质数)
 * 9 -> 1001 (2 个计算置位，2 是质数)
 * 10-> 1010 (2 个计算置位，2 是质数)
 * 共计 4 个计算置位为质数的数字。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：left = 10, right = 15
 * 输出：5
 * 解释：
 * 10 -> 1010 (2 个计算置位, 2 是质数)
 * 11 -> 1011 (3 个计算置位, 3 是质数)
 * 12 -> 1100 (2 个计算置位, 2 是质数)
 * 13 -> 1101 (3 个计算置位, 3 是质数)
 * 14 -> 1110 (3 个计算置位, 3 是质数)
 * 15 -> 1111 (4 个计算置位, 4 不是质数)
 * 共计 5 个计算置位为质数的数字。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= left <= right <= 10⁶
 * 0 <= right - left <= 10⁴
 * <p>
 * <p>
 * Related Topics 位运算 数学 👍 145 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimeSetBits(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            int num = num(i);
            if (zhishu(num)) {
                //   System.out.println(num);
                sum++;
            }
        }
        return sum;
    }

    int num(int n) {
        int i = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                i++;
            }
            n >>= 1;
        }
        return i;
    }

    boolean zhishu(int i) {
        if (i == 1) {
            return false;
        }
        for (int l = 2; l < i / 2 + 1; l++) {
            if (i % l == 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

