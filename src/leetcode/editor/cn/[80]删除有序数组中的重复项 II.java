// 开始时间：2023-09-26 19:01:07
// 题目标题：删除有序数组中的重复项 II
// 题目标记：remove-duplicates-from-sorted-array-ii
// 题目编号：80
// 题目描述：

import java.util.HashMap;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 3 * 10⁴
 * -10⁴ <= nums[i] <= 10⁴
 * nums 已按升序排列
 * <p>
 * <p>
 * Related Topics 数组 双指针 👍 896 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> result = new HashMap<>();
        int sum = 0, index = nums.length;
        for (int i = 0; i < index; i++) {
            sum++;
            Integer integer = result.merge(nums[i], 1, Integer::sum);
            if (integer > 2) {
                move(nums, i);
                sum--;
                i--;
                index--;
            }
        }
        for (int num : nums) {
            result.merge(num, 1, Integer::sum);
        }
        return sum;
//         return result.values().stream().map(o -> o > 2 ? 2 : o).mapToInt(o -> o).sum();
    }

    void move(int[] nums, int i) {
        if (nums.length - 1 - i >= 0) {
            System.arraycopy(nums, i + 1, nums, i, nums.length - 1 - i);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

