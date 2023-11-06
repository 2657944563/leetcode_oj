// 开始时间：2023-11-03 20:42:08
// 题目标题：按既定顺序创建目标数组
// 题目标记：create-target-array-in-the-given-order
// 题目编号：1389
// 题目描述：

import java.util.ArrayList;

/**
 * 给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
 * <p>
 * <p>
 * 目标数组 target 最初为空。
 * 按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
 * 重复上一步，直到在 nums 和 index 中都没有要读取的元素。
 * <p>
 * <p>
 * 请你返回目标数组。
 * <p>
 * 题目保证数字插入位置总是存在。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * 输出：[0,4,1,3,2]
 * 解释：
 * nums       index     target
 * 0            0        [0]
 * 1            1        [0,1]
 * 2            2        [0,1,2]
 * 3            2        [0,1,3,2]
 * 4            1        [0,4,1,3,2]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,0], index = [0,1,2,3,0]
 * 输出：[0,1,2,3,4]
 * 解释：
 * nums       index     target
 * 1            0        [1]
 * 2            1        [1,2]
 * 3            2        [1,2,3]
 * 4            3        [1,2,3,4]
 * 0            0        [0,1,2,3,4]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1], index = [0]
 * 输出：[1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length, index.length <= 100
 * nums.length == index.length
 * 0 <= nums[i] <= 100
 * 0 <= index[i] <= i
 * <p>
 * <p>
 * Related Topics 数组 模拟 👍 70 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

