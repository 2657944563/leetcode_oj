// 开始时间：2023-11-02 17:27:05
// 题目标题：检查整数及其两倍数是否存在
// 题目标记：check-if-n-and-its-double-exist
// 题目编号：1346
// 题目描述：

import java.util.HashSet;

/**
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 * <p>
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 * <p>
 * <p>
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [10,2,5,3]
 * 输出：true
 * 解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [7,1,14,11]
 * 输出：true
 * 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr = [3,1,7,11]
 * 输出：false
 * 解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 * <p>
 * <p>
 * Related Topics 数组 哈希表 双指针 二分查找 排序 👍 103 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i : arr) {
            if (hs.contains(i * 2)) {
                return true;
            }
            hs.add(i);
        }
        for (int i : arr) {
            if (i != 0 && hs.contains(i * 2)) {
                return true;
            }
        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

