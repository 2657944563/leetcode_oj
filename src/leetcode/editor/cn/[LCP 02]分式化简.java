// 开始时间：2023-09-20 16:32:26
// 题目标题：分式化简
// 题目标记：deep-dark-fraction
// 题目编号：LCP 02
// 题目描述：

/**
 * 有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？
 * <p>
 * <p>
 * <p>
 * 连分数是形如上图的分式。在本题中，所有系数都是大于等于0的整数。
 * <p>
 * <p>
 * <p>
 * 输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约
 * 数为1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：cont = [3, 2, 0, 2]
 * 输出：[13, 4]
 * 解释：原连分数等价于3 + (1 / (2 + (1 / (0 + 1 / 2))))。注意[26, 8], [-13, -4]都不是正确答案。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：cont = [0, 0, 3]
 * 输出：[3, 1]
 * 解释：如果答案是整数，令分母为1即可。
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * cont[i] >= 0
 * 1 <= cont的长度 <= 10
 * cont最后一个元素不等于0
 * 答案的n, m的取值都能被32位int整型存下（即不超过2 ^ 31 - 1）。
 * <p>
 * <p>
 * Related Topics 数组 数学 数论 模拟 👍 122 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] fraction(int[] cont) {
        int m = 0, n = 1;
        for (int i = cont.length - 1; i > 0; i--) {
            m += n * cont[i];
            m ^= n;
            n ^= m;
            m ^= n;
        }
        m += n * cont[0];
        return new int[]{m, n};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

