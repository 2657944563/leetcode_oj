// 开始时间：2023-10-19 09:42:56
// 题目标题：同积元组
// 题目标记：tuple-with-same-product
// 题目编号：1726
// 题目描述：

import java.util.Arrays;

/**
 * 给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 d 都
 * 是 nums 中的元素，且 a != b != c != d 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [2,3,4,6]
 * 输出：8
 * 解释：存在 8 个满足题意的元组：
 * (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
 * (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,4,5,10]
 * 输出：16
 * 解释：存在 16 个满足题意的元组：
 * (1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
 * (2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
 * (2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,4,5)
 * (4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 10⁴
 * nums 中的所有元素 互不相同
 * <p>
 * <p>
 * Related Topics 数组 哈希表 👍 50 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int tupleSameProduct(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int l = nums.length - 1; l > i + 2; l--) {
                int t = nums[l] * nums[i];
                int s = t / nums[i + 1];
                for (int j = i + 1; nums[j] < s; j++) {
                    if (t % nums[j] == 0) {
                        int m = Arrays.binarySearch(nums, j, l, t / nums[j]);
                        if (m > j) {
                            sum += 8;
                        }
                    }

                }
            }
        }
        return sum;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

