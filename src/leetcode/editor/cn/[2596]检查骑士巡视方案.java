/*
检查骑士巡视方案
2596
2023-09-13 11:19:36
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int i = 0, l = 0, n = 0, m = 1;
        while (m == grid[i][l] + 1) {
            n++;
            if (i + 1 < grid.length
                    && l + 2 < grid.length
                    && grid[i + 1][l + 2] == m) {
                i += 1;
                l += 2;
                m++;
            } else if (i + 2 < grid.length
                    && l + 1 < grid.length &&
                    grid[i + 2][l + 1] == m) {
                i += 2;
                l += 1;
                m++;
            } else if (i - 2 >= 0
                    && l + 1 < grid.length &&
                    grid[i - 2][l + 1] == m) {
                i -= 2;
                l += 1;
                m++;
            } else if (i - 1 >= 0
                    && l + 2 < grid.length &&
                    grid[i - 1][l + 2] == m) {
                i -= 1;
                l += 2;
                m++;
            } else if (i + 2 < grid.length
                    && l - 1 >= 0 &&
                    grid[i + 2][l - 1] == m) {
                i += 2;
                l -= 1;
                m++;
            } else if (i + 1 < grid.length
                    && l - 2 >= 0 &&
                    grid[i + 1][l - 2] == m) {
                i += 1;
                l -= 2;
                m++;
            } else if (i - 1 >= 0
                    && l - 2 >= 0 &&
                    grid[i - 1][l - 2] == m) {
                i -= 1;
                l -= 2;
                m++;
            } else if (i - 2 >= 0
                    && l - 1 >= 0 &&
                    grid[i - 2][l - 1] == m) {
                i -= 2;
                l -= 1;
                m++;
            } else {
                break;
            }
        }
        return n == grid.length * grid.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
