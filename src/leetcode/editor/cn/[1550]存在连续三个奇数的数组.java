// 开始时间：2025-08-23 20:18:26
// 题目标题：存在连续三个奇数的数组
// 题目标记：three-consecutive-odds
// 题目编号：1550
// 题目描述：

/**
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,6,4,1]
 * 输出：false
 * 解释：不存在连续三个元素都是奇数的情况。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,34,3,4,5,7,23,12]
 * 输出：true
 * 解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * <p>
 * <p>
 * Related Topics 数组 👍 51 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
                return true;
            }
        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

