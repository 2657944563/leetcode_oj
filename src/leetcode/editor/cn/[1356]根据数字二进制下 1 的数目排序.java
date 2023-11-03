// 开始时间：2023-11-02 17:27:06
// 题目标题：根据数字二进制下 1 的数目排序
// 题目标记：sort-integers-by-the-number-of-1-bits
// 题目编号：1356
// 题目描述：

import java.util.Arrays;

/**
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * <p>
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * <p>
 * 请你返回排序后的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
 * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr = [10000,10000]
 * 输出：[10000,10000]
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：arr = [2,3,5,7,11,13,17,19]
 * 输出：[2,3,5,17,7,11,13,19]
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * 输入：arr = [10,100,1000,10000]
 * 输出：[10,100,10000,1000]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^4
 * <p>
 * <p>
 * Related Topics 位运算 数组 计数 排序 👍 177 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] ints = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ints[i] = arr[i];
        }
        Arrays.sort(ints, (o1, o2) -> {
            int i1 = num(o1);
            int i2 = num(o2);
            if (i1 == i2) {
                return o1 - o2;
            }
            return i1 - i2;
        });
        return Arrays.stream(ints).mapToInt(Integer::intValue).toArray();
    }

    int num(int i) {
        System.out.print("i:" + i);
        int l = 0;
        while (i > 0) {
            if ((i & 1) == 1) {
                l++;
            }
            i >>= 1;
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

