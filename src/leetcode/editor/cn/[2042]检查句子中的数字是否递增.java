// 开始时间：2025-08-09 18:36:03
// 题目标题：检查句子中的数字是否递增
// 题目标记：check-if-numbers-are-ascending-in-a-sentence
// 题目编号：2042
// 题目描述：

/**
 * 句子是由若干 token 组成的一个列表，token 间用 单个 空格分隔，句子没有前导或尾随空格。每个 token 要么是一个由数字 0-9 组成的不含前导零
 * 的 正整数 ，要么是一个由小写英文字母组成的 单词 。
 * <p>
 * <p>
 * 示例，"a puppy has 2 eyes 4 legs" 是一个由 7 个 token 组成的句子："2" 和 "4" 是数字，其他像 "puppy" 这
 * 样的 tokens 属于单词。
 * <p>
 * <p>
 * 给你一个表示句子的字符串 s ，你需要检查 s 中的 全部 数字是否从左到右严格递增（即，除了最后一个数字，s 中的 每个 数字都严格小于它 右侧 的数字）。
 * <p>
 * <p>
 * 如果满足题目要求，返回 true ，否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles"
 * 输出：true
 * 解释：句子中的数字是：1, 3, 4, 6, 12 。
 * 这些数字是按从左到右严格递增的 1 < 3 < 4 < 6 < 12 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "hello world 5 x 5"
 * 输出：false
 * 解释：句子中的数字是：5, 5 。这些数字不是严格递增的。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：s = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"
 * 输出：false
 * 解释：s 中的数字是：7, 51, 50, 60 。这些数字不是严格递增的。
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：s = "4 5 11 26"
 * 输出：true
 * 解释：s 中的数字是：4, 5, 11, 26 。
 * 这些数字是按从左到右严格递增的：4 < 5 < 11 < 26 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 3 <= s.length <= 200
 * s 由小写英文字母、空格和数字 0 到 9 组成（包含 0 和 9）
 * s 中数字 token 的数目在 2 和 100 之间（包含 2 和 100）
 * s 中的 token 之间由单个空格分隔
 * s 中至少有 两个 数字
 * s 中的每个数字都是一个 小于 100 的 正 数，且不含前导零
 * s 不含前导或尾随空格
 * <p>
 * <p>
 * Related Topics 字符串 👍 65 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean areNumbersAscending(String s) {
        int m = -1;
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (isNumber(split[i])) {
                if (Integer.parseInt(split[i]) <= m) {
                    return false;
                } else {
                    m = Integer.parseInt(split[i]);
                }
            }
        }
        return true;

    }

    boolean isNumber(String s) {
        return s != null && !s.isEmpty() && s.charAt(0) >= '0' && s.charAt(0) <= '9';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

