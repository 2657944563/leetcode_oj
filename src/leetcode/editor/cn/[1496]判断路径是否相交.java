// 开始时间：2025-08-22 20:46:38
// 题目标题：判断路径是否相交
// 题目标记：path-crossing
// 题目编号：1496
// 题目描述：

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
 * <p>
 * 你从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
 * <p>
 * 如果路径在任何位置上与自身相交，也就是走到之前已经走过的位置，请返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：path = "NES"
 * 输出：false
 * 解释：该路径没有在任何位置相交。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：path = "NESWW"
 * 输出：true
 * 解释：该路径经过原点两次。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= path.length <= 10⁴
 * path[i] 为 'N'、'S'、'E' 或 'W'
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 👍 64 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        HashSet<String> hs = new HashSet<>(path.length());
        hs.add("x0y0");
        for (int i = 0; i < path.length(); i++) {
            path.charAt(i);
            switch (path.charAt(i)) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
                default:
            }
            if (hs.contains("x" + x + "y" + y)) {
                return true;
            } else {
                hs.add("x" + x + "y" + y);
            }
        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

