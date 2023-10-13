// 开始时间：2023-10-13 21:40:57
// 题目标题：独特的电子邮件地址
// 题目标记：unique-email-addresses
// 题目编号：929
// 题目描述：

import java.util.HashSet;

/**
 * 每个 有效电子邮件地址 都由一个 本地名 和一个 域名 组成，以 '@' 符号分隔。除小写字母之外，电子邮件地址还可以含有一个或多个 '.' 或 '+' 。
 * <p>
 * <p>
 * 例如，在 alice@leetcode.com中， alice 是 本地名 ，而 leetcode.com 是 域名 。
 * <p>
 * <p>
 * 如果在电子邮件地址的 本地名 部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名中没有点的同一地址。请注意，此规则 不适用于域名 。
 * <p>
 * <p>
 * 例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。
 * <p>
 * <p>
 * 如果在 本地名 中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件。同样，此规则 不适用于域名 。
 * <p>
 * <p>
 * 例如 m.y+name@email.com 将转发到 my@email.com。
 * <p>
 * <p>
 * 可以同时使用这两个规则。
 * <p>
 * 给你一个字符串数组 emails，我们会向每个 emails[i] 发送一封电子邮件。返回实际收到邮件的不同地址数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.
 * com","testemail+david@lee.tcode.com"]
 * 输出：2
 * 解释：实际收到邮件的是 "testemail@leetcode.com" 和 "testemail@lee.tcode.com"。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= emails.length <= 100
 * 1 <= emails[i].length <= 100
 * emails[i] 由小写英文字母、'+'、'.' 和 '@' 组成
 * 每个 emails[i] 都包含有且仅有一个 '@' 字符
 * 所有本地名和域名都不为空
 * 本地名不会以 '+' 字符作为开头
 * <p>
 * <p>
 * Related Topics 数组 哈希表 字符串 👍 250 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hs = new HashSet<>();
        for (String email : emails) {
            int left = email.indexOf('+');
            int right = email.lastIndexOf('@');
            String leftStr = email.substring(0, left == -1 ? right : left).replace(".", "");
            String rightStr = email.substring(right);
            hs.add(leftStr + rightStr);
        }
        return hs.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

