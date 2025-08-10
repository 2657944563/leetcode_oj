// 开始时间：2025-08-10 09:24:59
// 题目标题：重新排序得到 2 的幂
// 题目标记：reordered-power-of-2
// 题目编号：869
// 题目描述：

import java.util.*;

/**
 * 给定正整数 n ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * <p>
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 1
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 10
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 10⁹
 * <p>
 * <p>
 * Related Topics 哈希表 数学 计数 枚举 排序 👍 188 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] m = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912};
        HashSet<String> hashSet = new HashSet(m.length);
        for (int i : m) {
            hashSet.add(re(i));
        }
        return hashSet.contains(re(n));
    }

    String re(int i) {
        ArrayList<Integer> list = new ArrayList<>();
        while (i > 0) {
            list.add(i % 10);
            i /= 10;
        }
        Collections.sort(list);
        StringBuilder result = new StringBuilder();
        for (Integer integer : list) {
            result.append(integer);
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

