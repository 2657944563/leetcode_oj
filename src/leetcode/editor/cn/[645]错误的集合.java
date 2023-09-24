// 开始时间：2023-09-24 19:01:13
// 题目标题：错误的集合
// 题目标记：set-mismatch
// 题目编号：645
// 题目描述：

import java.util.Arrays;

/**
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个
 * 数字重复 。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * <p>
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,1]
 * 输出：[1,2]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= nums.length <= 10⁴
 * 1 <= nums[i] <= 10⁴
 * <p>
 * <p>
 * Related Topics 位运算 数组 哈希表 排序 👍 342 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findErrorNums(int[] nums) {
        int c = 0, f = 0;
        int[] result = new int[nums.length];
        for (int num : nums) {
            if (result[num - 1] == num) {
                c = num;
            }
            result[num - 1] = num;
        }
        System.out.println(Arrays.toString(result));
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) {
                f = i + 1;
            }
        }
        return new int[]{c, f};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

