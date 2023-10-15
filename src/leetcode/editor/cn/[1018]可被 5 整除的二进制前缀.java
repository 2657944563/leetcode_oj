// 开始时间：2023-10-14 20:11:50
// 题目标题：可被 5 整除的二进制前缀
// 题目标记：binary-prefix-divisible-by-5
// 题目编号：1018
// 题目描述：

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二进制数组 nums ( 索引从0开始 )。
 * <p>
 * 我们将xi 定义为其二进制表示形式为子数组 nums[0..i] (从最高有效位到最低有效位)。
 * <p>
 * <p>
 * 例如，如果 nums =[1,0,1] ，那么 x0 = 1, x1 = 2, 和 x2 = 5。
 * <p>
 * <p>
 * 返回布尔值列表 answer，只有当 xi 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为 true 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：[false,false,false]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * nums[i] 仅为 0 或 1
 * <p>
 * <p>
 * Related Topics 数组 👍 157 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        LinkedList<Boolean> result = new LinkedList<>();
        long count = 0;
        for (int num : nums) {
            count = count * 2 + num;
            result.add((count % 5 == 0));
            count = count % 5;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

