// 开始时间：2023-10-23 13:10:40
// 题目标题：“气球” 的最大数量
// 题目标记：maximum-number-of-balloons
// 题目编号：1189
// 题目描述：

import java.util.HashMap;

/**
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * <p>
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：text = "nlaebolko"
 * 输出：1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：text = "leetcode"
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= text.length <= 10^4
 * text 全部由小写英文字母组成
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 计数 👍 132 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            hm.merge(text.charAt(i), 1, Integer::sum);
        }
        int i = hm.get('b') == null ? 0 : hm.get('b');
        i = Math.min(i, hm.get('a') == null ? 0 : hm.get('a'));
        i = Math.min(i, hm.get('n') == null ? 0 : hm.get('n'));
        i = Math.min(i, hm.get('l') == null ? 0 : hm.get('l') / 2);
        i = Math.min(i, hm.get('o') == null ? 0 : hm.get('o') / 2);
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

