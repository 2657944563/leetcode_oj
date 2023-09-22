// 开始时间：2023-09-22 09:19:17
// 题目标题：将钱分给最多的儿童
// 题目标记：distribute-money-to-maximum-children
// 题目编号：2591
// 题目描述：

/**
 * 给你一个整数 money ，表示你总共有的钱数（单位为美元）和另一个整数 children ，表示你要将钱分配给多少个儿童。
 * <p>
 * 你需要按照如下规则分配：
 * <p>
 * <p>
 * 所有的钱都必须被分配。
 * 每个儿童至少获得 1 美元。
 * 没有人获得 4 美元。
 * <p>
 * <p>
 * 请你按照上述规则分配金钱，并返回 最多 有多少个儿童获得 恰好 8 美元。如果没有任何分配方案，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：money = 20, children = 3
 * 输出：1
 * 解释：
 * 最多获得 8 美元的儿童数为 1 。一种分配方案为：
 * - 给第一个儿童分配 8 美元。
 * - 给第二个儿童分配 9 美元。
 * - 给第三个儿童分配 3 美元。
 * 没有分配方案能让获得 8 美元的儿童数超过 1 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：money = 16, children = 2
 * 输出：2
 * 解释：每个儿童都可以获得 8 美元。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= money <= 200
 * 2 <= children <= 30
 * <p>
 * <p>
 * Related Topics 贪心 数学 👍 44 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        if (children * 8 < money) {
            return children - 1;
        }
        if (children * 8 - 4 == money) {
            return children - 2;
        }
        return (money - children) / 7;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

