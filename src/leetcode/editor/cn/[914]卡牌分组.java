// 开始时间：2023-10-10 22:39:32
// 题目标题：卡牌分组
// 题目标记：x-of-a-kind-in-a-deck-of-cards
// 题目编号：914
// 题目描述：

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 给定一副牌，每张牌上都写着一个整数。
 * <p>
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * <p>
 * <p>
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * <p>
 * <p>
 * 仅当你可选的 X >= 2 时返回 true。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：deck = [1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：deck = [1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= deck.length <= 10⁴
 * 0 <= deck[i] < 10⁴
 * <p>
 * <p>
 * Related Topics 数组 哈希表 数学 计数 数论 👍 288 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> hm = new HashMap<>(deck.length / 2);
        for (int i : deck) {
            hm.merge(i, 1, Integer::sum);
        }
        ArrayList<Integer> values = new ArrayList<>(hm.values());
        for (int i = 2; i <= values.get(0); i++) {
            int l = 0;
            for (Integer value : values) {
                if (value % i != 0) {
                    break;
                }
                if (++l == values.size()) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

