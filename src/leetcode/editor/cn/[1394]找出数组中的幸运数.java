// 开始时间：2023-11-03 20:42:08
// 题目标题：找出数组中的幸运数
// 题目标记：find-lucky-integer-in-an-array
// 题目编号：1394
// 题目描述：

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
 * <p>
 * 给你一个整数数组 arr，请你从中找出并返回一个幸运数。
 * <p>
 * <p>
 * 如果数组中存在多个幸运数，只需返回 最大 的那个。
 * 如果数组中不含幸运数，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,2,3,4]
 * 输出：2
 * 解释：数组中唯一的幸运数是 2 ，因为数值 2 的出现频次也是 2 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,2,3,3,3]
 * 输出：3
 * 解释：1、2 以及 3 都是幸运数，只需要返回其中最大的 3 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr = [2,2,2,3,3]
 * 输出：-1
 * 解释：数组中不存在幸运数。
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：arr = [5]
 * 输出：-1
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * 输入：arr = [7,7,7,7,7,7,7]
 * 输出：7
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr.length <= 500
 * 1 <= arr[i] <= 500
 * <p>
 * <p>
 * Related Topics 数组 哈希表 计数 👍 51 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : arr) {
            hm.merge(i, 1, Integer::sum);
        }
        return hm.entrySet().stream()
                .filter(o -> o.getKey().equals(o.getValue()))
                .max(Comparator.comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getKey)
                .orElse(-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

