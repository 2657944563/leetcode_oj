// 开始时间：2023-11-10 11:19:31
// 题目标题：咒语和药水的成功对数
// 题目标记：successful-pairs-of-spells-and-potions
// 题目编号：2300
// 题目描述：

import java.util.Arrays;

/**
 * 给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，其中 spells[i] 表示第 i 个咒语的能量强度，potions[j]
 * 表示第 j 瓶药水的能量强度。
 * <p>
 * 同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。
 * <p>
 * 请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：spells = [5,1,3], potions = [1,2,3,4,5], success = 7
 * 输出：[4,0,3]
 * 解释：
 * - 第 0 个咒语：5 * [1,2,3,4,5] = [5,10,15,20,25] 。总共 4 个成功组合。
 * - 第 1 个咒语：1 * [1,2,3,4,5] = [1,2,3,4,5] 。总共 0 个成功组合。
 * - 第 2 个咒语：3 * [1,2,3,4,5] = [3,6,9,12,15] 。总共 3 个成功组合。
 * 所以返回 [4,0,3] 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：spells = [3,1,2], potions = [8,5,8], success = 16
 * 输出：[2,0,2]
 * 解释：
 * - 第 0 个咒语：3 * [8,5,8] = [24,15,24] 。总共 2 个成功组合。
 * - 第 1 个咒语：1 * [8,5,8] = [8,5,8] 。总共 0 个成功组合。
 * - 第 2 个咒语：2 * [8,5,8] = [16,10,16] 。总共 2 个成功组合。
 * 所以返回 [2,0,2] 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == spells.length
 * m == potions.length
 * 1 <= n, m <= 10⁵
 * 1 <= spells[i], potions[i] <= 10⁵
 * 1 <= success <= 10¹⁰
 * <p>
 * <p>
 * Related Topics 数组 双指针 二分查找 排序 👍 58 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            result[i] = getN(potions, spells[i], success);
        }
        return result;

    }

    int getN(int[] potions, int target, long success) {
        int left = 0, right = potions.length - 1, mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if ((long) potions[mid] * target >= success) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return potions.length - left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

