// 开始时间：2023-11-03 20:42:09
// 题目标题：统计最大组的数目
// 题目标记：count-largest-group
// 题目编号：1399
// 题目描述：

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数 n 。请你先求出从 1 到 n 的每个整数 10 进制表示下的数位和（每一位上的数字相加），然后把数位和相等的数字放到同一个组中。
 * <p>
 * 请你统计每个组中的数字数目，并返回数字数目并列最多的组有多少个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 13
 * 输出：4
 * 解释：总共有 9 个组，将 1 到 13 按数位求和后这些组分别是：
 * [1,10]，[2,11]，[3,12]，[4,13]，[5]，[6]，[7]，[8]，[9]。总共有 4 个组拥有的数字并列最多。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：总共有 2 个大小为 1 的组 [1]，[2]。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 15
 * 输出：6
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：n = 24
 * 输出：5
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 10^4
 * <p>
 * <p>
 * Related Topics 哈希表 数学 👍 38 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            hm.merge(get(i), 1, Integer::sum);
        }
        return (int) hm.entrySet().stream()
                .filter(o -> o.getValue().equals(hm.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).map(Map.Entry::getValue).orElse(1)))
                .count();
    }

    int get(int i) {
        int l = 0;
        while (i > 0) {
            l += i % 10;
            i /= 10;
        }
        System.out.println(l);
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

