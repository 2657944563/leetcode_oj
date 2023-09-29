// 开始时间：2023-09-29 13:10:27
// 题目标题：自除数
// 题目标记：self-dividing-numbers
// 题目编号：728
// 题目描述：

import java.util.LinkedList;
import java.util.List;

/**
 * 自除数 是指可以被它包含的每一位数整除的数。
 * <p>
 * <p>
 * 例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * <p>
 * <p>
 * 自除数 不允许包含 0 。
 * <p>
 * 给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：left = 1, right = 22
 * 输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入：left = 47, right = 85
 * 输出：[48,55,66,77]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= left <= right <= 10⁴
 * <p>
 * <p>
 * Related Topics 数学 👍 261 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        LinkedList<Integer> result = new LinkedList<>();
        for (; left <= right; left++) {
            if (check(left, String.valueOf(left))) {
                result.add(left);
            }
        }
        return result;
    }

    boolean check(int l, String str) {
        for (char c : str.toCharArray()) {
            int o = c - '0';
            if (o == 0 || l % o != 0) {
                return false;
            }
        }
        return true;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

