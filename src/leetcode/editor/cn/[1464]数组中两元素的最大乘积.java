// 开始时间：2023-11-07 12:53:01
// 题目标题：数组中两元素的最大乘积
// 题目标记：maximum-product-of-two-elements-in-an-array
// 题目编号：1464
// 题目描述：

/**
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 * <p>
 * 请你计算并返回该式的最大值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,5,2]
 * 输出：12
 * 解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3
 * 4 = 12 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,5,4,5]
 * 输出：16
 * 解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [3,7]
 * 输出：12
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= nums.length <= 500
 * 1 <= nums[i] <= 10^3
 * <p>
 * <p>
 * Related Topics 数组 排序 堆（优先队列） 👍 108 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            if (num > a) {
                b = a;
                a = num;
            } else if (num > b) {
                b = num;
            }
        }
        return (a - 1) * (b - 1);

        //Arrays.sort(nums);
        // return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

