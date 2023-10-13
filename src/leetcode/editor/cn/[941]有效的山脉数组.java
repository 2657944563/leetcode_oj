// 开始时间：2023-10-13 21:41:00
// 题目标题：有效的山脉数组
// 题目标记：valid-mountain-array
// 题目编号：941
// 题目描述：

/**
 * 给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
 * <p>
 * 让我们回顾一下，如果 arr 满足下述条件，那么它是一个山脉数组：
 * <p>
 * <p>
 * arr.length >= 3
 * 在 0 < i < arr.length - 1 条件下，存在 i 使得：
 * <p>
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：arr = [2,1]
 * 输出：false
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：arr = [3,5,5]
 * 输出：false
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：arr = [0,3,2,1]
 * 输出：true
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr.length <= 10⁴
 * 0 <= arr[i] <= 10⁴
 * <p>
 * <p>
 * Related Topics 数组 👍 222 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int i = 0;
        while (i < arr.length - 1 && arr[i] < arr[i + 1]) {
            i++;
        }
        if (i == 0) {
            return false;
        }
        while (i < arr.length - 1 && arr[i] > arr[i + 1]) {
            if (i == arr.length - 2) {
                return true;
            }
            i++;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

