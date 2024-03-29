// 开始时间：2023-11-09 15:09:49
// 题目标题：逃离火灾
// 题目标记：escape-the-spreading-fire
// 题目编号：2258
// 题目描述：

/**
 * 给你一个下标从 0 开始大小为 m x n 的二维整数数组 grid ，它表示一个网格图。每个格子为下面 3 个值之一：
 * <p>
 * <p>
 * 0 表示草地。
 * 1 表示着火的格子。
 * 2 表示一座墙，你跟火都不能通过这个格子。
 * <p>
 * <p>
 * 一开始你在最左上角的格子 (0, 0) ，你想要到达最右下角的安全屋格子 (m - 1, n - 1) 。每一分钟，你可以移动到 相邻 的草地格子。每次你移动
 * 之后 ，着火的格子会扩散到所有不是墙的 相邻 格子。
 * <p>
 * 请你返回你在初始位置可以停留的 最多 分钟数，且停留完这段时间后你还能安全到达安全屋。如果无法实现，请你返回 -1 。如果不管你在初始位置停留多久，你 总是
 * 能到达安全屋，请你返回 10⁹ 。
 * <p>
 * 注意，如果你到达安全屋后，火马上到了安全屋，这视为你能够安全到达安全屋。
 * <p>
 * 如果两个格子有共同边，那么它们为 相邻 格子。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2],[0,0
 * ,0,0,0,0,0]]
 * 输出：3
 * 解释：上图展示了你在初始位置停留 3 分钟后的情形。
 * 你仍然可以安全到达安全屋。
 * 停留超过 3 分钟会让你无法安全到达安全屋。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,0,0,0],[0,1,2,0],[0,2,0,0]]
 * 输出：-1
 * 解释：上图展示了你马上开始朝安全屋移动的情形。
 * 火会蔓延到你可以移动的所有格子，所以无法安全到达安全屋。
 * 所以返回 -1 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,0,0],[2,2,0],[1,2,0]]
 * 输出：1000000000
 * 解释：上图展示了初始网格图。
 * 注意，由于火被墙围了起来，所以无论如何你都能安全到达安全屋。
 * 所以返回 10⁹ 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 300
 * 4 <= m * n <= 2 * 10⁴
 * grid[i][j] 是 0 ，1 或者 2 。
 * grid[0][0] == grid[m - 1][n - 1] == 0
 * <p>
 * <p>
 * Related Topics 广度优先搜索 数组 二分查找 矩阵 👍 97 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maximumMinutes(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 这里我用开区间二分（其它写法也可以）
        int left = -1, right = m * n + 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(grid, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left < m * n ? left : 1_000_000_000;
    }

    // 返回能否在初始位置停留 t 分钟，并安全到达安全屋
    private boolean check(int[][] grid, int t) {
        int m = grid.length, n = grid[0].length;
        boolean[][] onFire = new boolean[m][n];
        List<int[]> f = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    onFire[i][j] = true; // 标记着火的位置
                    f.add(new int[]{i, j});
                }
            }
        }
        while (t-- > 0 && !f.isEmpty()) { // 如果火无法扩散就提前退出
            f = spreadFire(grid, onFire, f); // 火扩散
        }
        if (onFire[0][0]) {
            return false; // 起点着火，寄
        }

        // 人的 BFS
        boolean[][] vis = new boolean[m][n];
        vis[0][0] = true;
        List<int[]> q = List.of(new int[]{0, 0});
        while (!q.isEmpty()) {
            List<int[]> tmp = q;
            q = new ArrayList<>();
            for (int[] p : tmp) {
                if (onFire[p[0]][p[1]]) { // 人走到这个位置后，火也扩散到了这个位置
                    continue;
                }
                for (int[] d : DIRS) { // 枚举上下左右四个方向
                    int x = p[0] + d[0], y = p[1] + d[1];
                    if (0 <= x && x < m && 0 <= y && y < n && !onFire[x][y] && !vis[x][y] && grid[x][y] == 0) {
                        if (x == m - 1 && y == n - 1) {
                            return true; // 我们安全了…暂时。
                        }
                        vis[x][y] = true; // 避免反复访问同一个位置
                        q.add(new int[]{x, y});
                    }
                }
            }
            f = spreadFire(grid, onFire, f); // 火扩散
        }
        return false; // 人被火烧到，或者没有可以到达安全屋的路
    }

    // 火的 BFS
    private List<int[]> spreadFire(int[][] grid, boolean[][] fire, List<int[]> f) {
        int m = grid.length, n = grid[0].length;
        List<int[]> tmp = f;
        f = new ArrayList<>();
        for (int[] p : tmp) {
            for (int[] d : DIRS) { // 枚举上下左右四个方向
                int x = p[0] + d[0], y = p[1] + d[1];
                if (0 <= x && x < m && 0 <= y && y < n && !fire[x][y] && grid[x][y] == 0) {
                    fire[x][y] = true; // 标记着火的位置
                    f.add(new int[]{x, y});
                }
            }
        }
        return f;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

