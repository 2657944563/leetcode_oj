// 开始时间：2023-09-26 19:01:05
// 题目标题：单词搜索
// 题目标记：word-search
// 题目编号：79
// 题目描述：

import java.util.HashSet;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
 * "ABCCED"
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
 * "SEE"
 * 输出：true
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
 * "ABCB"
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 * <p>
 * Related Topics 数组 回溯 矩阵 👍 1686 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    HashSet<String> h = new HashSet<>();
                    h.add(i + "" + j);
                    if (check(board, word, i, j, 1, h)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean check(char[][] board, String word, int x, int y, int i, HashSet<String> hashSet) {
        if (i == word.length()) {
            return true;
        }
        if (x - 1 >= 0 && board[x - 1][y] == word.charAt(i) && !hashSet.contains((x - 1) + "" + y)) {
            hashSet.add((x - 1) + "" + y);
            if (check(board, word, x - 1, y, i + 1, hashSet)) {
                return true;
            }
            hashSet.remove((x - 1) + "" + y);
        }
        if (y - 1 >= 0 && board[x][y - 1] == word.charAt(i) && !hashSet.contains(x + "" + (y - 1))) {
            hashSet.add(x + "" + (y - 1));
            if (check(board, word, x, y - 1, i + 1, hashSet)) {
                return true;
            }
            hashSet.remove(x + "" + (y - 1));
        }
        if (x + 1 < board.length && board[x + 1][y] == word.charAt(i) && !hashSet.contains((x + 1) + "" + y)) {
            hashSet.add((x + 1) + "" + y);
            if (check(board, word, x + 1, y, i + 1, hashSet)) {
                return true;
            }
            hashSet.remove((x + 1) + "" + y);
        }
        if (y + 1 < board[x].length && board[x][y + 1] == word.charAt(i) && !hashSet.contains(x + "" + (1 + y))) {
            hashSet.add(x + "" + (1 + y));
            if (check(board, word, x, y + 1, i + 1, hashSet)) {
                return true;
            }
            hashSet.remove(x + "" + (1 + y));
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

