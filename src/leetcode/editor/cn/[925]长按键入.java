// 开始时间：2023-10-10 22:39:37
// 题目标题：长按键入
// 题目标记：long-pressed-name
// 题目编号：925
// 题目描述：

/**
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * <p>
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= name.length, typed.length <= 1000
 * name 和 typed 的字符都是小写字母
 * <p>
 * <p>
 * Related Topics 双指针 字符串 👍 289 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length() || typed.charAt(0) != name.charAt(0)) {
            return false;
        }
        int l = 1, i = 1;
        for (; i < name.length() && l < typed.length(); i++, l++) {
            if (name.charAt(i) == typed.charAt(l)) {
                continue;
            } else {
                while (l < typed.length() && typed.charAt(l - 1) == typed.charAt(l)) {
                    l++;
                }
                if (l == typed.length() || name.charAt(i) != typed.charAt(l)) {
                    return false;
                }
            }
        }
        if (i != name.length()) {
            return false;
        }
        while (l < typed.length() && typed.charAt(l) == typed.charAt(l - 1)) {
            l++;
        }
        return l == typed.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

