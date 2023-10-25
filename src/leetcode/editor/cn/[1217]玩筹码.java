// 开始时间：2023-10-25 21:26:05
// 题目标题：玩筹码
// 题目标记：minimum-cost-to-move-chips-to-the-same-position
// 题目编号：1217
// 题目描述：

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 有 n 个筹码。第 i 个筹码的位置是
 * position[i] 。
 * <p>
 * 我们需要把所有筹码移到同一个位置。在一步中，我们可以将第 i 个筹码的位置从 position[i] 改变为:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * position[i] + 2 或 position[i] - 2 ，此时 cost = 0
 * position[i] + 1 或 position[i] - 1 ，此时 cost = 1
 * <p>
 * <p>
 * 返回将所有筹码移动到同一位置上所需要的 最小代价 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：position = [1,2,3]
 * 输出：1
 * 解释：第一步:将位置3的筹码移动到位置1，成本为0。
 * 第二步:将位置2的筹码移动到位置1，成本= 1。
 * 总成本是1。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：position = [2,2,2,3,3]
 * 输出：2
 * 解释：我们可以把位置3的两个筹码移到位置2。每一步的成本为1。总成本= 2。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入：position = [1,1000000000]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= position.length <= 100
 * 1 <= position[i] <= 10^9
 * <p>
 * <p>
 * Related Topics 贪心 数组 数学 👍 214 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostToMoveChips(int[] position) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : position) {
            hm.merge(i % 2, 1, Integer::sum);
        }
        int flag = hm.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).map(Map.Entry::getKey).get(), sum = 0;
        for (int i : position) {
            if (i % 2 != flag) {
                sum++;
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

