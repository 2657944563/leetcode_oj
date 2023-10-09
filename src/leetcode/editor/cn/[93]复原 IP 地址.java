// 开始时间：2023-10-09 21:18:03
// 题目标题：复原 IP 地址
// 题目标记：restore-ip-addresses
// 题目编号：93
// 题目描述：

import java.util.LinkedList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和
 * "192.168@1.1" 是 无效 IP 地址。
 * <p>
 * <p>
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序
 * 或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 20
 * s 仅由数字组成
 * <p>
 * <p>
 * Related Topics 字符串 回溯 👍 1324 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> restoreIpAddresses(String s) {
        LinkedList<String> result = new LinkedList<>();
        hs(result, new LinkedList<>(), s, 0);
        return result;

    }

    void hs(LinkedList<String> result, LinkedList<String> temp, String s, int i) {
        if (temp.size() == 4) {
            if (i == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (String s1 : temp) {
                    sb.append(s1).append(".");
                }
                result.add(sb.substring(0, sb.length() - 1));
            } else {
                return;
            }
        }
        for (int l = i + 1; l <= s.length(); l++) {
            String substring = s.substring(i, l);
            if (substring.length() > 1 && substring.charAt(0) == '0') {
                break;
            }
            if (Integer.parseInt(substring) <= 255) {
                temp.add(substring);
                hs(result, temp, s, l);
                temp.removeLast();
            } else {
                break;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

