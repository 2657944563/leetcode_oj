/*
将石头分散到网格图的最少移动次数
2850
2023-09-15 09:23:12
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int ans = Integer.MAX_VALUE;
    int[][] grid;

    public int minimumMoves(int[][] grid) {
        this.grid = grid;
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 0) {
                    cnt++;
                }
            }
        }
        dfs(0, cnt);
        return ans;
    }

    //sum记录移动方案对应的移动次数
    //cnt记录剩余石头数为0的格子数
    private void dfs(int sum, int cnt) {
        if (cnt == 0) {
            ans = Math.min(sum, ans);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 0) {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            if (grid[k][l] > 1) {
                                grid[k][l]--;
                                grid[i][j] = 1;
                                dfs(sum + Math.abs(i - k) + Math.abs(j - l), cnt - 1);
                                grid[k][l]++;
                                grid[i][j] = 0;
                            }
                        }
                    }
                }
            }
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
