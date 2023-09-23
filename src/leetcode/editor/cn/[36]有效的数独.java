// 开始时间：2023-09-23 11:08:47
// 题目标题：有效的数独
// 题目标记：valid-sudoku
// 题目编号：36
// 题目描述：

import java.util.HashSet;

/**
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：false
 * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的
 * 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字（1-9）或者 '.'
 * <p>
 * <p>
 * Related Topics 数组 哈希表 矩阵 👍 1157 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!hang(board, i) || !lie(board, i)) {
                return false;
            }
        }
        for (int i = 0; i < board[0].length; i += 3) {
            for (int l = 0; l < board[0].length; l += 3) {
                if (!ge(board, i, l)) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean ge(char[][] board, int i, int l) {
        HashSet<Character> hashSet = new HashSet<>();
        for (int m = i; m < i + 3; m++) {
            for (int n = l; n < l + 3; n++) {
                char c = board[m][n];
                if (c != '.' && hashSet.contains(c)) {
                    return false;
                }
                hashSet.add(c);
            }
        }
        return true;
    }

    boolean hang(char[][] board, int i) {
        HashSet<Character> hashSet = new HashSet<>();
        for (int j = 0; j < board[i].length; j++) {
            char l = board[i][j];
            if (l != '.' && hashSet.contains(l)) {
                return false;
            }
            hashSet.add(l);
        }
        return true;
    }

    boolean lie(char[][] board, int i) {
        HashSet<Character> hashSet = new HashSet<>();
        for (int j = 0; j < board[i].length; j++) {
            char l = board[j][i];
            if (l != '.' && hashSet.contains(l)) {
                return false;
            }
            hashSet.add(l);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

