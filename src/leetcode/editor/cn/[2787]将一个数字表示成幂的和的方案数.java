// 开始时间：2025-08-12 20:34:12
// 题目标题：将一个数字表示成幂的和的方案数
// 题目标记：ways-to-express-an-integer-as-sum-of-powers
// 题目编号：2787
// 题目描述：

import java.util.ArrayList;

/**
 * 给你两个 正 整数 n 和 x 。
 * <p>
 * 请你返回将 n 表示成一些 互不相同 正整数的 x 次幂之和的方案数。换句话说，你需要返回互不相同整数 [n1, n2, ..., nk] 的集合数目，满足
 * n = n1ˣ + n2ˣ + ... + nkˣ 。
 * <p>
 * 由于答案可能非常大，请你将它对 10⁹ + 7 取余后返回。
 * <p>
 * 比方说，n = 160 且 x = 3 ，一个表示 n 的方法是 n = 2³ + 3³ + 5³ 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10, x = 2
 * 输出：1
 * 解释：我们可以将 n 表示为：n = 3² + 1² = 10 。
 * 这是唯一将 10 表达成不同整数 2 次方之和的方案。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 4, x = 1
 * 输出：2
 * 解释：我们可以将 n 按以下方案表示：
 * - n = 4¹ = 4 。
 * - n = 3¹ + 1¹ = 4 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 300
 * 1 <= x <= 5
 * <p>
 * <p>
 * Related Topics 动态规划 👍 55 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int numberOfWays(int n, int x) {
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 1;; i++) {
//            int pow = pow(i, x);
//            if (pow > n) {
//                break;
//            }
//            if (n % pow == 0) {
//                list.add(pow);
//            }
//        }
//        for (Integer integer : list) {
//            System.out.print(integer+" ");
//        }
//        return dg(list,list.size()-1,n);
//    }
//
//    int dg(ArrayList<Integer> list, int i, int n) {
//        if (i < 0 || n < 0) {
//            return 0;
//        }
//        if (n == 0) {
//            return 1;
//        }
//        return dg(list, i - 1, n - list.get(i)) + dg(list, i - 1, n);
//    }
//
//    int pow(int i, int n) {
//        int s = i;
//        for (int i1 = 1; i1 < n; i1++) {
//            i *= i;
//        }
//        return s;
//    }
//}
class Solution {
    public int numberOfWays(int n, int x) {
        long[] dp = new long[n + 1];
        int mod = (int) 1e9 + 7;
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int power = (int) Math.pow((double) i, x);
            if (power > n)
                break;
            for (int j = n; j >= power; j--) {
                dp[j] = (dp[j] + dp[j - power]) % mod;
            }
        }
        return (int) dp[n] % mod;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

