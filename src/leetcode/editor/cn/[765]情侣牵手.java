// 开始时间：2023-11-11 12:21:53
// 题目标题：情侣牵手
// 题目标记：couples-holding-hands
// 题目编号：765
// 题目描述：

/**
 * n 对情侣坐在连续排列的 2n 个座位上，想要牵到对方的手。
 * <p>
 * 人和座位由一个整数数组 row 表示，其中 row[i] 是坐在第 i 个座位上的人的 ID。情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)
 * ，以此类推，最后一对是 (2n-2, 2n-1)。
 * <p>
 * 返回 最少交换座位的次数，以便每对情侣可以并肩坐在一起。 每次交换可选择任意两人，让他们站起来交换座位。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: row = [0,2,1,3]
 * 输出: 1
 * 解释: 只需要交换row[1]和row[2]的位置即可。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: row = [3,2,0,1]
 * 输出: 0
 * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 2n == row.length
 * 2 <= n <= 30
 * n 是偶数
 * 0 <= row[i] < 2n
 * row 中所有元素均无重复
 * <p>
 * <p>
 * Related Topics 贪心 深度优先搜索 广度优先搜索 并查集 图 👍 466 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int ans = 0;
        int[] cache = new int[n];
        for (int i = 0; i < n; i++) cache[row[i]] = i;
        for (int i = 0; i < n - 1; i += 2) {
            int a = row[i], b = a ^ 1;
            if (row[i + 1] != b) {
                int src = i + 1, tar = cache[b];
                cache[row[tar]] = src;
                cache[row[src]] = tar;
                swap(row, src, tar);
                ans++;
            }
        }
        return ans;
    }

    void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

