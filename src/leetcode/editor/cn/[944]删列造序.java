// 开始时间：2023-10-13 21:41:01
// 题目标题：删列造序
// 题目标记：delete-columns-to-make-sorted
// 题目编号：944
// 题目描述：

/**
 * 给你由 n 个小写字母字符串组成的数组 strs，其中每个字符串长度相等。
 * <p>
 * 这些字符串可以每个一行，排成一个网格。例如，strs = ["abc", "bce", "cae"] 可以排列为：
 * <p>
 * <p>
 * abc
 * bce
 * cae
 * <p>
 * 你需要找出并删除 不是按字典序非严格递增排列的 列。在上面的例子（下标从 0 开始）中，列 0（'a', 'b', 'c'）和列 2（'c', 'e',
 * 'e'）都是按字典序非严格递增排列的，而列 1（'b', 'c', 'a'）不是，所以要删除列 1 。
 * <p>
 * 返回你需要删除的列数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：strs = ["cba","daf","ghi"]
 * 输出：1
 * 解释：网格示意如下：
 * cba
 * daf
 * ghi
 * 列 0 和列 2 按升序排列，但列 1 不是，所以只需要删除列 1 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：strs = ["a","b"]
 * 输出：0
 * 解释：网格示意如下：
 * a
 * b
 * 只有列 0 这一列，且已经按升序排列，所以不用删除任何列。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：strs = ["zyx","wvu","tsr"]
 * 输出：3
 * 解释：网格示意如下：
 * zyx
 * wvu
 * tsr
 * 所有 3 列都是非升序排列的，所以都要删除。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == strs.length
 * 1 <= n <= 100
 * 1 <= strs[i].length <= 1000
 * strs[i] 由小写英文字母组成
 * <p>
 * <p>
 * Related Topics 数组 字符串 👍 111 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDeletionSize(String[] strs) {
        int sum = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char c = 'a';
            for (String str : strs) {
                if (str.charAt(i) < c) {
                    sum++;
                    break;
                } else {
                    c = str.charAt(i);
                }
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

