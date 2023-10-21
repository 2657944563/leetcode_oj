// 开始时间：2023-10-19 10:59:32
// 题目标题：复写零
// 题目标记：duplicate-zeros
// 题目编号：1089
// 题目描述：

/**
 * 给你一个长度固定的整数数组 arr ，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * <p>
 * 注意：请不要在超过该数组长度的位置写入元素。请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：arr = [1,0,2,3,0,4,5,0]
 * 输出：[1,0,0,2,3,0,0,4]
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：arr = [1,2,3]
 * 输出：[1,2,3]
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr.length <= 10⁴
 * 0 <= arr[i] <= 9
 * <p>
 * <p>
 * Related Topics 数组 双指针 👍 264 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                r(arr, i);
                arr[i] = 0;
                i++;
            }
        }
    }

    void r(int[] array, int i) {
        for (int l = array.length - 1; l > 0; l--) {
            if (l == i) {
                break;
            } else {
                array[l] = array[l - 1];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

