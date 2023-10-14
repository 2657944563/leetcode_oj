// 开始时间：2023-10-13 23:04:09
// 题目标题：数组形式的整数加法
// 题目标记：add-to-array-form-of-integer
// 题目编号：989
// 题目描述：

import java.util.ArrayList;
import java.util.List;

/**
 * 整数的 数组形式 num 是按照从左到右的顺序表示其数字的数组。
 * <p>
 * <p>
 * 例如，对于 num = 1321 ，数组形式是 [1,3,2,1] 。
 * <p>
 * <p>
 * 给定 num ，整数的 数组形式 ，和整数 k ，返回 整数 num + k 的 数组形式 。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：num = [1,2,0,0], k = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：num = [2,7,4], k = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：num = [2,1,5], k = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= num.length <= 10⁴
 * 0 <= num[i] <= 9
 * num 不包含任何前导零，除了零本身
 * 1 <= k <= 10⁴
 * <p>
 * <p>
 * Related Topics 数组 数学 👍 242 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        ArrayList<Integer> result = new ArrayList<>(num.length);
        for (int i = 0; i < num.length; i++) {
            result.add(i, num[i]);
        }
        int i = 0;
        while (k > 0) {
            if (num.length - 1 - i >= 0) {
                result.set(num.length - 1 - i, result.get(num.length - 1 - i) + k % 10);
            } else {
                result.add(0, k % 10);
            }
            k /= 10;
            i++;
        }
        for (int size = result.size() - 1; size >= 0; size--) {
            Integer integer = result.get(size);
            if (integer >= 10) {
                if (size == 0) {
                    result.add(0, integer / 10);
                    result.set(1, integer % 10);
                    return result;
                } else {
                    result.set(size, integer % 10);
                    result.set(size - 1, result.get(size - 1) + integer / 10);
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

