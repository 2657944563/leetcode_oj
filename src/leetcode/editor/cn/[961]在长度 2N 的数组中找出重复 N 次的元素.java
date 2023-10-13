// 开始时间：2023-10-13 22:55:38
// 题目标题：在长度 2N 的数组中找出重复 N 次的元素
// 题目标记：n-repeated-element-in-size-2n-array
// 题目编号：961
// 题目描述：

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，该数组具有以下属性：
 * <p>
 * <p>
 * <p>
 * <p>
 * nums.length == 2 * n.
 * nums 包含 n + 1 个 不同的 元素
 * nums 中恰有一个元素重复 n 次
 * <p>
 * <p>
 * <p>
 * <p>
 * 找出并返回重复了 n 次的那个元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,3,3]
 * 输出：3
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [2,1,2,5,3,2]
 * 输出：2
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [5,1,5,2,5,3,5,4]
 * 输出：5
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= n <= 5000
 * nums.length == 2 * n
 * 0 <= nums[i] <= 10⁴
 * nums 由 n + 1 个 不同的 元素组成，且其中一个元素恰好重复 n 次
 * <p>
 * <p>
 * Related Topics 数组 哈希表 👍 191 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;
        HashMap<Integer, Integer> hm = new HashMap<>(n);
        for (int num : nums) {
            Integer i = hm.get(num);
            if (i != null) {
                if (i + 1 == n) {
                    return num;
                }
                hm.put(num, i + 1);
            } else {
                hm.put(num, 1);
            }
        }
        return 0;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

