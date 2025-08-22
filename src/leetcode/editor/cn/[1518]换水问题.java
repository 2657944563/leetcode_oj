// 开始时间：2025-08-22 21:19:13
// 题目标题：换水问题
// 题目标记：water-bottles
// 题目编号：1518
// 题目描述：

/**
 * 超市正在促销，你可以用 numExchange 个空水瓶从超市兑换一瓶水。最开始，你一共购入了 numBottles 瓶水。
 * <p>
 * 如果喝掉了水瓶中的水，那么水瓶就会变成空的。
 * <p>
 * 给你两个整数 numBottles 和 numExchange ，返回你 最多 可以喝到多少瓶水。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：numBottles = 9, numExchange = 3
 * 输出：13
 * 解释：你可以用 3 个空瓶兑换 1 瓶水。
 * 所以最多能喝到 9 + 3 + 1 = 13 瓶水。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：numBottles = 15, numExchange = 4
 * 输出：19
 * 解释：你可以用 4 个空瓶兑换 1 瓶水。
 * 所以最多能喝到 15 + 3 + 1 = 19 瓶水。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= numBottles <= 100
 * 2 <= numExchange <= 100
 * <p>
 * <p>
 * Related Topics 数学 模拟 👍 178 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int s = numBottles;
        while (numBottles >= numExchange) {
            s += numBottles / numExchange;
            numBottles = numBottles / numExchange + numBottles % numExchange;
        }
        return s;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

