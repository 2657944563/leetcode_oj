// 开始时间：2023-10-21 11:26:51
// 题目标题：统计无向图中无法互相到达点对数
// 题目标记：count-unreachable-pairs-of-nodes-in-an-undirected-graph
// 题目编号：2316
// 题目描述：

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 给你一个整数 n ，表示一张 无向图 中有 n 个节点，编号为 0 到 n - 1 。同时给你一个二维整数数组 edges ，其中 edges[i] = [
 * ai, bi] 表示节点 ai 和 bi 之间有一条 无向 边。
 * <p>
 * 请你返回 无法互相到达 的不同 点对数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 3, edges = [[0,1],[0,2],[1,2]]
 * 输出：0
 * 解释：所有点都能互相到达，意味着没有点对无法互相到达，所以我们返回 0 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
 * 输出：14
 * 解释：总共有 14 个点对互相无法到达：
 * [[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6],[
 * 5,6]]
 * 所以我们返回 14 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 10⁵
 * 0 <= edges.length <= 2 * 10⁵
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * 不会有重复边。
 * <p>
 * <p>
 * Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 53 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            uf.union(x, y);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += n - uf.getSize(uf.find(i));
        }
        return res / 2;
    }
}

class UnionFind {
    int[] parents;
    int[] sizes;

    public UnionFind(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        sizes = new int[n];
        Arrays.fill(sizes, 1);
    }

    public int find(int x) {
        if (parents[x] == x) {
            return x;
        } else {
            parents[x] = find(parents[x]);
            return parents[x];
        }
    }

    public void union(int x, int y) {
        int rx = find(x), ry = find(y);
        if (rx != ry) {
            if (sizes[rx] > sizes[ry]) {
                parents[ry] = rx;
                sizes[rx] += sizes[ry];
            } else {
                parents[rx] = ry;
                sizes[ry] += sizes[rx];
            }
        }
    }

    public int getSize(int x) {
        return sizes[x];
    }
}

//leetcode submit region end(Prohibit modification and deletion)

