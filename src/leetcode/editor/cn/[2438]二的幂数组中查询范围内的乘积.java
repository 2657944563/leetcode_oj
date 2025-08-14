// 开始时间：2025-08-11 18:24:36
// 题目标题：二的幂数组中查询范围内的乘积
// 题目标记：range-product-queries-of-powers
// 题目编号：2438
// 题目描述：

import java.util.ArrayList;

/**
 * 给你一个正整数 n ，你需要找到一个下标从 0 开始的数组 powers ，它包含 最少 数目的 2 的幂，且它们的和为 n 。powers 数组是 非递减 顺
 * 序的。根据前面描述，构造 powers 数组的方法是唯一的。
 * <p>
 * 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] ，其中 queries[i] 表
 * 示请你求出满足 lefti <= j <= righti 的所有 powers[j] 的乘积。
 * <p>
 * 请你返回一个数组 answers ，长度与 queries 的长度相同，其中 answers[i]是第 i 个查询的答案。由于查询的结果可能非常大，请你将每个
 * answers[i] 都对 10⁹ + 7 取余 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 15, queries = [[0,1],[2,2],[0,3]]
 * 输出：[2,4,64]
 * 解释：
 * 对于 n = 15 ，得到 powers = [1,2,4,8] 。没法得到元素数目更少的数组。
 * 第 1 个查询的答案：powers[0] * powers[1] = 1 * 2 = 2 。
 * 第 2 个查询的答案：powers[2] = 4 。
 * 第 3 个查询的答案：powers[0] * powers[1] * powers[2] * powers[3] = 1 * 2 * 4 * 8 = 64 。
 * 每个答案对 10⁹ + 7 取余得到的结果都相同，所以返回 [2,4,64] 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 2, queries = [[0,0]]
 * 输出：[2]
 * 解释：
 * 对于 n = 2, powers = [2] 。
 * 唯一一个查询的答案是 powers[0] = 2 。答案对 10⁹ + 7 取余后结果相同，所以返回 [2] 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 10⁹
 * 1 <= queries.length <= 10⁵
 * 0 <= starti <= endi < powers.length
 * <p>
 * <p>
 * Related Topics 位运算 数组 前缀和 👍 43 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productQueries(int n, int[][] queries) {
        ArrayList<Integer> list = new ArrayList<>();
        long[] result = new long[queries.length];
        int log = 1000000007;
        int o = 0;
        while (n > 0) {
            int s = n % 2;
            for (int i = 0; i < o; i++) {
                s *= 2;
            }
            if (s != 0) {
                list.add(s);
            }
            o++;
            n /= 2;
        }
        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (result[i] == 0) {
                    result[i] = list.get(j);
                } else {
                    result[i] = (result[i] * list.get(j)) % log;
                }

            }
        }
        int[] tt = new int[result.length];
        for (int i = 0; i < result.length; i++) {
            tt[i] = Math.toIntExact(result[i]);
        }
        return tt;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

