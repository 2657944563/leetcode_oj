// 开始时间：2023-10-25 21:46:36
// 题目标题：统计位数为偶数的数字
// 题目标记：find-numbers-with-even-number-of-digits
// 题目编号：1295
// 题目描述：

/**
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [12,345,2,6,7896]
 * 输出：2
 * 解释：
 * 12 是 2 位数字（位数为偶数） 
 * 345 是 3 位数字（位数为奇数）  
 * 2 是 1 位数字（位数为奇数） 
 * 6 是 1 位数字 位数为奇数） 
 * 7896 是 4 位数字（位数为偶数）  
 * 因此只有 12 和 7896 是位数为偶数的数字
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [555,901,482,1771]
 * 输出：1
 * 解释：
 * 只有 1771 是位数为偶数的数字。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 10^5
 * <p>
 * <p>
 * Related Topics 数组 👍 85 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            if (num >= 10 && num <= 99) {
                result++;
            } else if (num >= 1000 && num <= 9999) {
                result++;
            } else if (num >= 100000 && num <= 999999) {
                result++;
            }
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

