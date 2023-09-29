// 开始时间：2023-09-29 13:10:23
// 题目标题：宝石与石头
// 题目标记：jewels-and-stones
// 题目编号：771
// 题目描述：

/**
 * 给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。 stones 中每个字符代表了一种你拥有的石头的类型，你想
 * 知道你拥有的石头中有多少是宝石。
 * <p>
 * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：jewels = "aA", stones = "aAAbbbb"
 * 输出：3
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：jewels = "z", stones = "ZZ"
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= jewels.length, stones.length <= 50
 * jewels 和 stones 仅由英文字母组成
 * jewels 中的所有字符都是 唯一的
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 👍 795 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        return (int) stones.chars().filter(o -> jewels.contains(Character.toString(o))).count();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

