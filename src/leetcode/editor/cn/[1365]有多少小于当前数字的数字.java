// 开始时间：2023-11-03 20:42:05
// 题目标题：有多少小于当前数字的数字
// 题目标记：how-many-numbers-are-smaller-than-the-current-number
// 题目编号：1365
// 题目描述：

import java.util.Arrays;

/**
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * <p>
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * <p>
 * 以数组形式返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 * <p>
 * <p>
 * Related Topics 数组 哈希表 计数 排序 👍 273 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[nums.length];
        System.arraycopy(nums, 0, arr, 0, nums.length);
        Arrays.sort(nums);
        for (int i = 0; i < arr.length; i++) {
            int n = 0;
            for (int l = 0; l < nums.length; l++) {
                if (nums[l] == arr[i]) {
                    n = l;
                    break;
                }
            }
            arr[i] = n;
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

