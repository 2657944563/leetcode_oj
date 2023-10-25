// 开始时间：2023-10-25 21:26:04
// 题目标题：独一无二的出现次数
// 题目标记：unique-number-of-occurrences
// 题目编号：1207
// 题目描述：

import java.util.Arrays;
import java.util.HashSet;

/**
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * <p>
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [1,2]
 * 输出：false
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 * <p>
 * <p>
 * Related Topics 数组 哈希表 👍 209 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int l = 1;
            while (i < arr.length - 1 && arr[i + 1] == arr[i]) {
                l++;
                i++;
            }
            if (hs.contains(l)) {
                return false;
            } else {
                hs.add(l);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

