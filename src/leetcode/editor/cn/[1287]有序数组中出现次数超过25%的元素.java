// 开始时间：2023-10-25 21:46:34
// 题目标题：有序数组中出现次数超过25%的元素
// 题目标记：element-appearing-more-than-25-in-sorted-array
// 题目编号：1287
// 题目描述：

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 * <p>
 * 请你找到并返回这个整数
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 * <p>
 * <p>
 * Related Topics 数组 👍 77 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findSpecialInteger(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : arr) {
            hm.merge(i, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > (arr.length >= 4 ? arr.length / 4 : 1)) {
                return entry.getKey();
            }
        }
        return 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

