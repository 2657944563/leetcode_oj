// 开始时间：2023-11-03 20:42:08
// 题目标题：两个数组间的距离值
// 题目标记：find-the-distance-value-between-two-arrays
// 题目编号：1385
// 题目描述：

/**
 * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 * <p>
 * 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
 * 输出：2
 * 解释：
 * 对于 arr1[0]=4 我们有：
 * |4-10|=6 > d=2
 * |4-9|=5 > d=2
 * |4-1|=3 > d=2
 * |4-8|=4 > d=2
 * 所以 arr1[0]=4 符合距离要求
 * <p>
 * 对于 arr1[1]=5 我们有：
 * |5-10|=5 > d=2
 * |5-9|=4 > d=2
 * |5-1|=4 > d=2
 * |5-8|=3 > d=2
 * 所以 arr1[1]=5 也符合距离要求
 * <p>
 * 对于 arr1[2]=8 我们有：
 * |8-10|=2 <= d=2
 * |8-9|=1 <= d=2
 * |8-1|=7 > d=2
 * |8-8|=0 <= d=2
 * 存在距离小于等于 2 的情况，不符合距离要求
 * <p>
 * 故而只有 arr1[0]=4 和 arr1[1]=5 两个符合距离要求，距离值为 2
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3
 * 输出：2
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr1.length, arr2.length <= 500
 * -10^3 <= arr1[i], arr2[j] <= 10^3
 * 0 <= d <= 100
 * <p>
 * <p>
 * Related Topics 数组 双指针 二分查找 排序 👍 115 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int r = 0;
        for (int i : arr1) {
            for (int l = 0; l < arr2.length; l++) {
                if (Math.abs(i - arr2[l]) <= d) {
                    break;
                } else if (l == arr2.length - 1) {
                    r++;
                }
            }
        }
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

