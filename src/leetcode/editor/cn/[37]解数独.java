import java.util.*;

/*
解数独
37
2023-07-05 13:36:57
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solveSudoku(char[][] board) {
        //status[0] : raws, status[1] : cols, status[2] : cubes
        boolean[][][] status = new boolean[3][9][9];
        Deque<int[]> idxs = new ArrayDeque<>();
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] == '.') {
                    idxs.offer(new int[]{i, j});
                } else {
                    int num = board[i][j] - '1';
                    status[0][i][num] = status[1][j][num] = status[2][(i / 3) * 3 + j / 3][num] = true;
                }
        dfs(board, status, idxs);
    }

    private boolean dfs(char[][] board, boolean[][][] status, Deque<int[]> idxs) {
        if (idxs.isEmpty()) return true;
        int[] idx = idxs.poll();
        boolean[] raw = status[0][idx[0]];
        boolean[] col = status[1][idx[1]];
        boolean[] cube = status[2][(idx[0] / 3) * 3 + idx[1] / 3];
        for (int i = 0; i < 9; i++) {
            if (!raw[i] && !col[i] && !cube[i]) {
                raw[i] = col[i] = cube[i] = true;
                board[idx[0]][idx[1]] = (char) ('1' + i);
                if (dfs(board, status, idxs)) {
                    return true;
                } else {
                    raw[i] = col[i] = cube[i] = false;
                }
            }
        }
        idxs.push(idx);
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
