// 开始时间：2023-09-21 10:07:31
// 题目标题：收集树中金币
// 题目标记：collect-coins-in-a-tree
// 题目编号：2603
// 题目描述：

/**
 * 给你一个 n 个节点的无向无根树，节点编号从 0 到 n - 1 。给你整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i]
 * = [ai, bi] 表示树中节点 ai 和 bi 之间有一条边。再给你一个长度为 n 的数组 coins ，其中 coins[i] 可能为 0 也可能为 1
 * ，1 表示节点 i 处有一个金币。
 * <p>
 * 一开始，你需要选择树中任意一个节点出发。你可以执行下述操作任意次：
 * <p>
 * <p>
 * 收集距离当前节点距离为 2 以内的所有金币，或者
 * 移动到树中一个相邻节点。
 * <p>
 * <p>
 * 你需要收集树中所有的金币，并且回到出发节点，请你返回最少经过的边数。
 * <p>
 * 如果你多次经过一条边，每一次经过都会给答案加一。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：coins = [1,0,0,0,0,1], edges = [[0,1],[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 解释：从节点 2 出发，收集节点 0 处的金币，移动到节点 3 ，收集节点 5 处的金币，然后移动回节点 2 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：coins = [0,0,0,1,1,0,0,1], edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[5,6],[5,7
 * ]]
 * 输出：2
 * 解释：从节点 0 出发，收集节点 4 和 3 处的金币，移动到节点 2 处，收集节点 7 处的金币，移动回节点 0 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == coins.length
 * 1 <= n <= 3 * 10⁴
 * 0 <= coins[i] <= 1
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * edges 表示一棵合法的树。
 * <p>
 * <p>
 * Related Topics 树 图 拓扑排序 数组 👍 68 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[] gCoins;

    List<List<Integer>> g = new ArrayList<>();

    int[] gCost;
    int[][] dp;
    int gAns = Integer.MAX_VALUE;

    int[] dfs(int u, int fa) {
        int c0 = gCoins[u];
        int c1 = 0, c2 = 0;

        List<Integer> es = g.get(u);

        int h = 0;
        for (int v : es) {
            if (v == fa) continue;
            int[] cres = dfs(v, u);

            c1 += cres[0];
            c2 += cres[1];

            if (gCost[v] > 0) {
                h += gCost[v] + 2;
            } else if (cres[2] > 0) {
                h += 2;
            }
        }

        dp[u] = new int[]{c0, c1, c2};
        gCost[u] = h;
        return dp[u];
    }

    // *) 继续换根处理
    void dfs2(int u, int fa, int h, int[] path) {

        List<Integer> es = g.get(u);

        int nh = 0;
        if (h > 0) {
            nh = gCost[u] + h + 2;
            gAns = Math.min(gAns, gCost[u] + h + 2);
        } else {
            nh = gCost[u] + ((path[2] > 0) ? 2 : 0);
            gAns = Math.min(gAns, gCost[u] + ((path[2] > 0) ? 2 : 0));
        }

        int[] npath = new int[]{
                dp[u][0], dp[u][1] + path[0], dp[u][2] + path[1]
        };


        for (int v : es) {
            if (v == fa) continue;

            int[] cdp = dp[v];
            int cnh = nh;
            if (gCost[v] > 0) {
                cnh -= gCost[v] + 2;
            } else if (cdp[2] > 0) {
                cnh -= 2;
            }

            int[] cnpath = new int[]{
                    npath[0], npath[1] - cdp[0], npath[2] - cdp[1]
            };

            dfs2(v, u, cnh, cnpath);
        }

    }

    public int collectTheCoins(int[] coins, int[][] edges) {

        int n = coins.length;
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.get(u).add(v);
            g.get(v).add(u);
        }

        this.gCoins = coins;
        this.dp = new int[n][4];
        gCost = new int[n];

        dfs(0, -1);
        dfs2(0, -1, 0, new int[]{0, 0, 0});

        return gAns;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

