// 开始时间：2023-10-14 20:11:49
// 题目标题：将数组分成和相等的三个部分
// 题目标记：partition-array-into-three-parts-with-equal-sum
// 题目编号：1013
// 题目描述：

/**
 * 给你一个整数数组 arr，只有可以将其划分为三个和相等的 非空 部分时才返回 true，否则返回 false。
 * <p>
 * 形式上，如果可以找出索引 i + 1 < j 且满足 (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[
 * i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1]) 就可
 * 以将数组三等分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：arr = [0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：arr = [0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：arr = [3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 3 <= arr.length <= 5 * 10⁴
 * -10⁴ <= arr[i] <= 10⁴
 * <p>
 * <p>
 * Related Topics 贪心 数组 👍 204 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i] + (i > 0 ? left[i - 1] : 0);
        }
        for (int i = right.length - 1; i >= 0; i--) {
            right[i] = arr[i] + (i < right.length - 1 ? right[i + 1] : 0);
        }
        for (int i = 0; i < left.length - 1; i++) {
            for (int l = right.length - 1; l > i + 1; l--) {
                if (left[i] == right[l] && right[0] - left[i] - right[l] == left[i]) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

