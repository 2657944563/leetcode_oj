import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
N 皇后 II
52
2023-09-04 14:54:54
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> re;

    public int totalNQueens(int n) {

        solveNQueens(n);
        return re.size();
    }

    public List<List<String>> solveNQueens(int n) {
        re = new LinkedList<>();
        char[][] result = new char[n][n];
        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], '.');
        }
        rac(result, 0);
        return re;
    }

    // n 行 m 列
    void rac(char[][] result, int n) {
        if (n == result.length) {
            add(result);
            return;
        }
        for (int m = 0; m < result.length; m++) {
            if (verify(result, n, m)) {
                result[n][m] = 'Q';
                rac(result, n + 1);
                result[n][m] = '.';
            }
        }
    }

    // n 行 m 列
    boolean verify(char[][] result, int n, int m) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < result.length; j++) {
                if (result[i][j] == 'Q') {
                    // 同一个
                    if (i == n && m == j) {
                        continue;
                    }
                    // 同一斜线
                    if (i - j == n - m) {
                        return false;
                    }
                    if (i + j == n + m) {
                        return false;
                    }
                    // 同一行
                    if (i == n) {
                        return false;
                    }
                    // 同一列
                    if (j == m) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    void add(char[][] result) {
        LinkedList<String> s = new LinkedList<>();
        re.add(s);
        for (int i = 0; i < result.length; i++) {
            s.add(String.valueOf(result[i]));
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
