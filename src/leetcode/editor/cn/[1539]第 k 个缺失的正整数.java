// 开始时间：2025-08-23 19:56:40
// 题目标题：第 k 个缺失的正整数
// 题目标记：kth-missing-positive-number
// 题目编号：1539
// 题目描述：

/**
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 * <p>
 * 请你找到这个数组里第 k 个缺失的正整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：arr = [2,3,4,7,11], k = 5
 * 输出：9
 * 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：arr = [1,2,3,4], k = 2
 * 输出：6
 * 解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 1 <= k <= 1000
 * 对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j]
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以设计一个时间复杂度小于 O(n) 的算法解决此问题吗？
 * <p>
 * Related Topics 数组 二分查找 👍 262 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 0, n = 1;
        while (k > 0) {
            if (i < arr.length && n == arr[i]) {
                i++;
                n++;
                continue;
            }
            if (--k == 0) {
                return n;
            }
            ++n;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

