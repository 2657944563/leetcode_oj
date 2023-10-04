// 开始时间：2023-10-04 15:34:42
// 题目标题：1 比特与 2 比特字符
// 题目标记：1-bit-and-2-bit-characters
// 题目编号：717
// 题目描述：

/**
 * 有两种特殊字符：
 * <p>
 * <p>
 * 第一种字符可以用一比特 0 表示
 * 第二种字符可以用两比特（10 或 11）表示
 * <p>
 * <p>
 * 给你一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一个一比特字符，则返回 true 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: bits = [1, 0, 0]
 * 输出: true
 * 解释: 唯一的解码方式是将其解析为一个两比特字符和一个一比特字符。
 * 所以最后一个字符是一比特字符。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入：bits = [1,1,1,0]
 * 输出：false
 * 解释：唯一的解码方式是将其解析为两比特字符和两比特字符。
 * 所以最后一个字符不是一比特字符。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= bits.length <= 1000
 * bits[i] 为 0 或 1
 * <p>
 * <p>
 * Related Topics 数组 👍 300 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 1) {
                i++;
            } else if (i == bits.length - 1) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

