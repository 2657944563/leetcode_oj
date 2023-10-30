// 开始时间：2023-10-30 18:06:18
// 题目标题：H 指数 II
// 题目标记：h-index-ii
// 题目编号：275
// 题目描述：

/**
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，citations 已经按照 升序排列 。计算并
 * 返回该研究者的 h 指数。
 * <p>
 * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （n 篇论文中）总共有 h 篇论文分别被引用了
 * 至少 h 次。
 * <p>
 * 请你设计并实现对数时间复杂度的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：citations = [0,1,3,5,6]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
 *      由于研究者有3篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：citations = [1,2,100]
 * 输出：2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == citations.length
 * 1 <= n <= 10⁵
 * 0 <= citations[i] <= 1000
 * citations 按 升序排列
 * <p>
 * <p>
 * Related Topics 数组 二分查找 👍 281 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;   // 数组个数
        int l = 0;                  // 左边界
        int r = n;                  // 右边界
        int mid;                    // 中间值
        int res = 0;                // 结果值，初始为0
        while (l < r) {
            mid = l + ((r - l) >> 1);
            // 此时的h值为n-mid，取引用数较大的前n-mid本书
            // 如果mid位置的书引用数大于等于h，说明这个h成立，缩小右边界尝试找到更小的mid以找到更大的h
            // 否则h过大，应该扩大左边界尝试找到更大的mid以找到更小的h
            if (citations[mid] >= n - mid) {
                res = n - mid;  // 找到一个h暂存
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

