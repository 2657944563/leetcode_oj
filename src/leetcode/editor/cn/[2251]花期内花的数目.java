// 开始时间：2023-09-28 10:07:36
// 题目标题：花期内花的数目
// 题目标记：number-of-flowers-in-full-bloom
// 题目编号：2251
// 题目描述：

import java.util.Arrays;

/**
 * 给你一个下标从 0 开始的二维整数数组 flowers ，其中 flowers[i] = [starti, endi] 表示第 i 朵花的 花期 从
 * starti 到 endi （都 包含）。同时给你一个下标从 0 开始大小为 n 的整数数组 people ，people[i] 是第 i 个人来看花的时间。
 * <p>
 * 请你返回一个大小为 n 的整数数组 answer ，其中 answer[i]是第 i 个人到达时在花期内花的 数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]
 * 输出：[1,2,2,2]
 * 解释：上图展示了每朵花的花期时间，和每个人的到达时间。
 * 对每个人，我们返回他们到达时在花期内花的数目。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：flowers = [[1,10],[3,3]], people = [3,3,2]
 * 输出：[2,2,1]
 * 解释：上图展示了每朵花的花期时间，和每个人的到达时间。
 * 对每个人，我们返回他们到达时在花期内花的数目。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= flowers.length <= 5 * 10⁴
 * flowers[i].length == 2
 * 1 <= starti <= endi <= 10⁹
 * 1 <= people.length <= 5 * 10⁴
 * 1 <= people[i] <= 10⁹
 * <p>
 * <p>
 * Related Topics 数组 哈希表 二分查找 有序集合 前缀和 排序 👍 82 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        var starts = new int[n];
        var ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = flowers[i][0];
            ends[i] = flowers[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int i = 0; i < people.length; i++) {
            people[i] = lowerBound(starts, people[i] + 1) - lowerBound(ends, people[i]);
        }
        return people;
    }

    // 返回 >= x 的第一个数的下标
    // 如果不存在（所有元素都小于 x），则返回 nums.length
    private int lowerBound(int[] nums, int x) {
        int left = -1, right = nums.length; // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // nums[left] < x
            // nums[right] >= x
            int mid = left + (right - left) / 2;
            if (nums[mid] < x) {
                left = mid; // 区间缩小为 (mid, right)
            } else {
                right = mid; // 区间缩小为 (left, mid)
            }
        }
        return right; // 根据循环不变量，此时 right 就是满足 nums[right] >= x 的最小值
    }
}

//leetcode submit region end(Prohibit modification and deletion)

