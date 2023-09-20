// 开始时间：2023-09-20 16:30:40
// 题目标题：猜数字
// 题目标记：guess-numbers
// 题目编号：LCP 01
// 题目描述：

/**
 * 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A
 * 猜对了几次？
 * <p>
 * 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：guess = [1,2,3], answer = [1,2,3]
 * 输出：3
 * 解释：小A 每次都猜对了。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：guess = [2,2,3], answer = [3,2,1]
 * 输出：1
 * 解释：小A 只猜对了第二次。
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * guess 的长度 = 3
 * answer 的长度 = 3
 * guess 的元素取值为 {1, 2, 3} 之一。
 * answer 的元素取值为 {1, 2, 3} 之一。
 * <p>
 * <p>
 * Related Topics 数组 👍 153 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int game(int[] guess, int[] answer) {
        int sum = 0;
        for (int i = 0; i < guess.length; i++) {
            if (answer[i] == guess[i]) {
                sum++;
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

