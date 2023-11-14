// 开始时间：2023-11-14 14:11:34
// 题目标题：阈值距离内邻居最少的城市
// 题目标记：find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
// 题目编号：1334
// 题目描述：

/**
 * 有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，其中 edges[i] = [fromi, toi, weighti] 代表
 * fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数 distanceThreshold。
 * <p>
 * 返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。如果有多个这样的城市，则返回编号最大的城市。
 * <p>
 * 注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
 * 输出：3
 * 解释：城市分布图如上。
 * 每个城市阈值距离 distanceThreshold = 4 内的邻居城市分别是：
 * 城市 0 -> [城市 1, 城市 2] 
 * 城市 1 -> [城市 0, 城市 2, 城市 3] 
 * 城市 2 -> [城市 0, 城市 1, 城市 3] 
 * 城市 3 -> [城市 1, 城市 2] 
 * 城市 0 和 3 在阈值距离 4 以内都有 2 个邻居城市，但是我们必须返回城市 3，因为它的编号最大。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]],
 * distanceThreshold = 2
 * 输出：0
 * 解释：城市分布图如上。 
 * 每个城市阈值距离 distanceThreshold = 2 内的邻居城市分别是：
 * 城市 0 -> [城市 1] 
 * 城市 1 -> [城市 0, 城市 4] 
 * 城市 2 -> [城市 3, 城市 4] 
 * 城市 3 -> [城市 2, 城市 4]
 * 城市 4 -> [城市 1, 城市 2, 城市 3] 
 * 城市 0 在阈值距离 2 以内只有 1 个邻居城市。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= n <= 100
 * 1 <= edges.length <= n * (n - 1) / 2
 * edges[i].length == 3
 * 0 <= fromi < toi < n
 * 1 <= weighti, distanceThreshold <= 10^4
 * 所有 (fromi, toi) 都是不同的。
 * <p>
 * <p>
 * Related Topics 图 动态规划 最短路 👍 147 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] map = new int[n][n];
        final int INF = 0x3f3f3f3f;
        //init map
        for (int[] ints : map) {
            Arrays.fill(ints, INF);
        }
        for (int i = 0; i < n; i++) {
            map[i][i] = 0;
        }
        for (int[] e : edges) {
            map[e[0]][e[1]] = map[e[1]][e[0]] = e[2];
        }
        int res = 0;
        int MIN = n + 1;

        for (int i = 0; i < n; i++) {
            int[] dist = new int[n];
            boolean[] set = new boolean[n];
            for (int v = 0; v < n; v++) {
                dist[v] = map[i][v];
            }
            dist[i] = 0;
            set[i] = true;
            for (int j = 0; j < n - 1; j++) {
                int min = INF;
                int start = i;
                for (int k = 0; k < n; k++) {
                    if (!set[k] && dist[k] < min) {
                        min = dist[k];
                        start = k;
                    }
                }
                set[start] = true;
                for (int k = 0; k < n; k++) {
                    if (!set[k] && dist[k] > dist[start] + map[start][k]) {
                        dist[k] = dist[start] + map[start][k];
                    }
                }
            }
            int temp = 0;
            for (int j = 0; j < dist.length; j++) {
                if (dist[j] <= distanceThreshold) {
                    temp++;
                }
            }
            if (temp <= MIN) {
                MIN = temp;
                res = i;
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

