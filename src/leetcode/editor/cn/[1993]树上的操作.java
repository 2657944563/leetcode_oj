// 开始时间：2023-09-23 09:59:12
// 题目标题：树上的操作
// 题目标记：operations-on-tree
// 题目编号：1993
// 题目描述：

import java.util.HashMap;

/**
 * 给你一棵 n 个节点的树，编号从 0 到 n - 1 ，以父节点数组 parent 的形式给出，其中 parent[i] 是第 i 个节点的父节点。树的根节点为
 * 0 号节点，所以 parent[0] = -1 ，因为它没有父节点。你想要设计一个数据结构实现树里面对节点的加锁，解锁和升级操作。
 * <p>
 * 数据结构需要支持如下函数：
 * <p>
 * <p>
 * Lock：指定用户给指定节点 上锁 ，上锁后其他用户将无法给同一节点上锁。只有当节点处于未上锁的状态下，才能进行上锁操作。
 * Unlock：指定用户给指定节点 解锁 ，只有当指定节点当前正被指定用户锁住时，才能执行该解锁操作。
 * Upgrade：指定用户给指定节点 上锁 ，并且将该节点的所有子孙节点 解锁 。只有如下 3 个条件 全部 满足时才能执行升级操作：
 * <p>
 * 指定节点当前状态为未上锁。
 * 指定节点至少有一个上锁状态的子孙节点（可以是 任意 用户上锁的）。
 * 指定节点没有任何上锁的祖先节点。
 * <p>
 * <p>
 * <p>
 * 请你实现 LockingTree 类：
 * <p>
 * <p>
 * LockingTree(int[] parent) 用父节点数组初始化数据结构。
 * lock(int num, int user) 如果 id 为 user 的用户可以给节点 num 上锁，那么返回 true ，否则返回 false 。如果可
 * 以执行此操作，节点 num 会被 id 为 user 的用户 上锁 。
 * unlock(int num, int user) 如果 id 为 user 的用户可以给节点 num 解锁，那么返回 true ，否则返回 false 。如
 * 果可以执行此操作，节点 num 变为 未上锁 状态。
 * upgrade(int num, int user) 如果 id 为 user 的用户可以给节点 num 升级，那么返回 true ，否则返回 false 。
 * 如果可以执行此操作，节点 num 会被 升级 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：
 * ["LockingTree", "lock", "unlock", "unlock", "lock", "upgrade", "lock"]
 * [[[-1, 0, 0, 1, 1, 2, 2]], [2, 2], [2, 3], [2, 2], [4, 5], [0, 1], [0, 1]]
 * 输出：
 * [null, true, false, true, true, true, false]
 * <p>
 * 解释：
 * LockingTree lockingTree = new LockingTree([-1, 0, 0, 1, 1, 2, 2]);
 * lockingTree.lock(2, 2);    // 返回 true ，因为节点 2 未上锁。
 * // 节点 2 被用户 2 上锁。
 * lockingTree.unlock(2, 3);  // 返回 false ，因为用户 3 无法解锁被用户 2 上锁的节点。
 * lockingTree.unlock(2, 2);  // 返回 true ，因为节点 2 之前被用户 2 上锁。
 * // 节点 2 现在变为未上锁状态。
 * lockingTree.lock(4, 5);    // 返回 true ，因为节点 4 未上锁。
 * // 节点 4 被用户 5 上锁。
 * lockingTree.upgrade(0, 1); // 返回 true ，因为节点 0 未上锁且至少有一个被上锁的子孙节点（节点 4）。
 * // 节点 0 被用户 1 上锁，节点 4 变为未上锁。
 * lockingTree.lock(0, 1);    // 返回 false ，因为节点 0 已经被上锁了。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == parent.length
 * 2 <= n <= 2000
 * 对于 i != 0 ，满足 0 <= parent[i] <= n - 1
 * parent[0] == -1
 * 0 <= num <= n - 1
 * 1 <= user <= 10⁴
 * parent 表示一棵合法的树。
 * lock ，unlock 和 upgrade 的调用 总共 不超过 2000 次。
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 设计 哈希表 👍 33 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class LockingTree {
    int p[];
    int n;
    Map<Integer, List<Integer>> map = new HashMap<>();
    int l[];

    public LockingTree(int[] parent) {
        p = parent.clone();
        n = p.length;
        l = new int[n];
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(p[i], new ArrayList<>());
            list.add(i);
            map.put(p[i], list);
            l[i] = -1;
        }
    }

    public boolean lock(int num, int user) {
        if (l[num] != -1) return false;
        l[num] = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if (l[num] == user) {
            l[num] = -1;
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        if (l[num] != -1) return false;
        int numt = num;
        int usert = user;
        List<Integer> list = map.getOrDefault(num, new ArrayList<>());
        boolean child = false;
        for (int i : list) {
            child = child || child(i);
        }
        if (!child) return false;
        boolean pf = parent(-1, num);

        if (!pf) return false;
        update(num);
        l[num] = user;
        return true;
    }

    private boolean child(int num) {
        if (l[num] != -1) return true;
        List<Integer> list = map.getOrDefault(num, new ArrayList<>());
        for (int i : list) {
            if (child(i)) return true;
        }
        return false;
    }

    private boolean parent(int k, int num) {
        if (k == num) return true;
        if (k >= 0 && l[k] != -1) return false;
        List<Integer> list = map.getOrDefault(k, new ArrayList<>());
        boolean f = false;
        for (int i : list) {
            f = f || parent(i, num);
        }
        return f;
    }

    private void update(int num) {
        l[num] = -1;
        List<Integer> list = map.getOrDefault(num, new ArrayList<>());
        for (int i : list) {
            update(i);
        }
    }
}


/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */
//leetcode submit region end(Prohibit modification and deletion)

