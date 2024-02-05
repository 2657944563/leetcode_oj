// 开始时间：2024-02-05 09:24:02
// 题目标题：跳跃游戏 VII
// 题目标记：jump-game-vii
// 题目编号：1871
// 题目描述：

/**
 * 给你一个下标从 0 开始的二进制字符串 s 和两个整数 minJump 和 maxJump 。一开始，你在下标 0 处，且该位置的值一定为 '0' 。当同时满足
 * 如下条件时，你可以从下标 i 移动到下标 j 处：
 * <p>
 * <p>
 * i + minJump <= j <= min(i + maxJump, s.length - 1) 且
 * s[j] == '0'.
 * <p>
 * <p>
 * 如果你可以到达 s 的下标 s.length - 1 处，请你返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "011010", minJump = 2, maxJump = 3
 * 输出：true
 * 解释：
 * 第一步，从下标 0 移动到下标 3 。
 * 第二步，从下标 3 移动到下标 5 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "01101110", minJump = 2, maxJump = 3
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= s.length <= 10⁵
 * s[i] 要么是 '0' ，要么是 '1'
 * s[0] == '0'
 * 1 <= minJump <= maxJump < s.length
 * <p>
 * <p>
 * Related Topics 字符串 动态规划 前缀和 滑动窗口 👍 87 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int[] res = new int[s.length()];
        int sumL = 0, sumR = 0;
        res[0] = 1;
        for (int i = 1; i < minJump; i++) if (s.charAt(i) == '0' && (sumR - sumL) > 0) res[i] = 1;
        for (int i = minJump; i < maxJump + 1; i++) {
            sumR += res[i - minJump];
            if (s.charAt(i) == '0' && (sumR - sumL) > 0) res[i] = 1;
        }
        for (int i = maxJump + 1; i < s.length(); i++) {
            sumR += res[i - minJump];
            sumL += res[i - maxJump - 1];
            if (s.charAt(i) == '0' && (sumR - sumL) > 0) res[i] = 1;
        }
        return res[s.length() - 1] == 1 ? true : false;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

