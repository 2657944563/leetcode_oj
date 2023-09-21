// 开始时间：2023-09-20 22:25:50
// 题目标题：心算挑战
// 题目标记：uOAnQW
// 题目编号：LCP 40
// 题目描述：

import java.util.Arrays;

/**
 * 「力扣挑战赛」心算项目的挑战比赛中，要求选手从 `N` 张卡牌中选出 `cnt` 张卡牌，若这 `cnt` 张卡牌数字总和为偶数，则选手成绩「有效」且得分为 `
 * cnt` 张卡牌数字总和。
 * 给定数组 `cards` 和 `cnt`，其中 `cards[i]` 表示第 `i` 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分的卡
 * 牌方案，则返回 0。
 * <p>
 * *示例 1：**
 * <p>
 * > 输入：`cards = [1,2,8,9], cnt = 3`
 * >
 * > 输出：`18`
 * >
 * > 解释：选择数字为 1、8、9 的这三张卡牌，此时可获得最大的有效得分 1+8+9=18。
 * <p>
 * *示例 2：**
 * <p>
 * > 输入：`cards = [3,3,1], cnt = 1`
 * >
 * > 输出：`0`
 * >
 * > 解释：不存在获取有效得分的卡牌方案。
 * <p>
 * *提示：**
 * - `1 <= cnt <= cards.length <= 10^5`
 * - `1 <= cards[i] <= 1000`
 * <p>
 * Related Topics 贪心 数组 排序 👍 53 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxmiumScore(int[] cards, int cnt) {
        // 遇事不决，优先排序
        Arrays.sort(cards);
        int n = cards.length;
        int score = 0;
        for (int i = n - 1; i >= n - cnt; i--) {
            score += cards[i];
        }
        // 排序先取最大的cnt个数，如果它们的和是偶数直接输出
        if (score % 2 == 0) {
            return score;
            // 不然就找一个已取的最小的奇数换成剩下未取的最大的偶数，或者找一个已取的最小的偶数换成剩下未取的最大奇数
        } else {
            // 先去最大的cnt个数，若sum为偶数，直接返回
            // 若为奇数，则在已选的数字中，和未选择的数字中选择差值最小且奇偶性相反的数字交换
            int min = Integer.MAX_VALUE;
            for (int i = n - cnt; i < n; i++) {
                for (int j = n - cnt - 1; j >= 0; j--) {
                    if (cards[i] % 2 == 0 && cards[j] % 2 != 0) {
                        min = Math.min(min, cards[i] - cards[j]);
                        break;
                    } else if (cards[i] % 2 != 0 && cards[j] % 2 == 0) {
                        min = Math.min(min, cards[i] - cards[j]);
                        break;
                    }
                }
            }
            if (min == Integer.MAX_VALUE) {
                return 0;
            } else {
                return score - min;
            }
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)

