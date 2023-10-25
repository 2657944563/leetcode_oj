// 开始时间：2023-10-25 21:46:36
// 题目标题：将每个元素替换为右侧最大元素
// 题目标记：replace-elements-with-greatest-element-on-right-side
// 题目编号：1299
// 题目描述：

/**
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 * <p>
 * 完成所有替换操作后，请你返回这个数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：arr = [17,18,5,4,6,1]
 * 输出：[18,6,6,6,1,-1]
 * 解释：
 * - 下标 0 的元素 --> 右侧最大元素是下标 1 的元素 (18)
 * - 下标 1 的元素 --> 右侧最大元素是下标 4 的元素 (6)
 * - 下标 2 的元素 --> 右侧最大元素是下标 4 的元素 (6)
 * - 下标 3 的元素 --> 右侧最大元素是下标 4 的元素 (6)
 * - 下标 4 的元素 --> 右侧最大元素是下标 5 的元素 (1)
 * - 下标 5 的元素 --> 右侧没有其他元素，替换为 -1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：arr = [400]
 * 输出：[-1]
 * 解释：下标 0 的元素右侧没有其他元素。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr.length <= 10⁴
 * 1 <= arr[i] <= 10⁵
 * <p>
 * <p>
 * Related Topics 数组 👍 96 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int max = arr[i + 1];
            for (int l = i + 1; l < arr.length; l++) {
                max = Math.max(max, arr[l]);
            }
            arr[i] = max;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

