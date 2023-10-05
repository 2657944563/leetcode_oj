// 开始时间：2023-10-04 20:26:26
// 题目标题：唯一摩尔斯密码词
// 题目标记：unique-morse-code-words
// 题目编号：804
// 题目描述：

import java.util.HashSet;

/**
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如:
 * <p>
 * <p>
 * 'a' 对应 ".-" ，
 * 'b' 对应 "-..." ，
 * 'c' 对应 "-.-." ，以此类推。
 * <p>
 * <p>
 * 为了方便，所有 26 个英文字母的摩尔斯密码表如下：
 * <p>
 * <p>
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--",
 * "-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..
 * "]
 * <p>
 * 给你一个字符串数组 words ，每个单词可以写成每个字母对应摩尔斯密码的组合。
 * <p>
 * <p>
 * 例如，"cab" 可以写成 "-.-..--..." ，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作 单词翻
 * 译 。
 * <p>
 * <p>
 * 对 words 中所有单词进行单词翻译，返回不同 单词翻译 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入: words = ["gin", "zen", "gig", "msg"]
 * 输出: 2
 * 解释:
 * 各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * <p>
 * 共有 2 种不同翻译, "--...-." 和 "--...--.".
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：words = ["a"]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 12
 * words[i] 由小写英文字母组成
 * <p>
 * <p>
 * Related Topics 数组 哈希表 字符串 👍 256 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> hashSet = new HashSet<>();
        String[] mappingTable = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (char c : words[i].toCharArray()) {
                sb.append(mappingTable[c - 'a']);
            }
            hashSet.add(sb.toString());
        }
        return hashSet.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

