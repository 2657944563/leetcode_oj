// 开始时间：2023-10-22 12:34:27
// 题目标题：等价多米诺骨牌对的数量
// 题目标记：number-of-equivalent-domino-pairs
// 题目编号：1128
// 题目描述：

import com.sun.source.doctree.SummaryTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 * <p>
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 * <p>
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b=
 * =c。
 * <p>
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i,
 * j) 的数量。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 * <p>
 * <p>
 * Related Topics 数组 哈希表 计数 👍 156 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public int numEquivDominoPairs(int[][] dominoes) {
        for (int[] dominoe : dominoes) {
            if (dominoe[0] > dominoe[1]) {
                dominoe[0] ^= dominoe[1];
                dominoe[1] ^= dominoe[0];
                dominoe[0] ^= dominoe[1];
            }
        }
        HashMap<String, Integer> hm = new HashMap<>();
        for (int[] dominoe : dominoes) {
            hm.merge(dominoe[0] + ":" + dominoe[1], 1, Integer::sum);
        }
        int n = hm.values().stream().filter(o -> o > 1).mapToInt(o -> get(o - 1)).sum();
        return n;
    }

    int get(int i) {
        if (hashMap.containsKey(i)) {
            return hashMap.get(i);
        }
        int sum = 0;
        for (int l = 1; l <= i; l++) {
            sum += l;
            if (!hashMap.containsKey(l)) {
                hashMap.put(l, sum);
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

