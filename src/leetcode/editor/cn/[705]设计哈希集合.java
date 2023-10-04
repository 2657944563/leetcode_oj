// 开始时间：2023-10-03 15:08:46
// 题目标题：设计哈希集合
// 题目标记：design-hashset
// 题目编号：705
// 题目描述：

import java.util.LinkedList;

/**
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * <p>
 * 实现 MyHashSet 类：
 * <p>
 * <p>
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove",
 * "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * 输出：
 * [null, null, null, true, false, null, true, null, false]
 * <p>
 * 解释：
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // 返回 True
 * myHashSet.contains(3); // 返回 False ，（未找到）
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // 返回 True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // 返回 False ，（已移除）
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= key <= 10⁶
 * 最多调用 10⁴ 次 add、remove 和 contains
 * <p>
 * <p>
 * Related Topics 设计 数组 哈希表 链表 哈希函数 👍 311 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class MyHashSet {
    LinkedList<Integer>[] hash;
    int size;
    int count;

    public MyHashSet() {
        size = 16;
        count = 0;
        hash = new LinkedList[size];
    }

    public void add(int key) {
        if (count == size) {
            resize();
        }
        int h = key % size;
        LinkedList<Integer> integers = hash[h];
        if (integers == null) {
            LinkedList<Integer> newList = new LinkedList<>();
            newList.add(key);
            hash[h] = newList;
        } else {
            if (!integers.contains(key)) {
                integers.add(key);
            }
        }
        count++;

    }

    public void remove(int key) {
        int h = key % size;
        LinkedList<Integer> integers = hash[h];
        if (integers != null && integers.remove((Integer) key)) {
            count--;
        }
    }

    public boolean contains(int key) {
        int h = key % size;
        LinkedList<Integer> integers = hash[h];
        if (integers != null) {
            return integers.contains(key);
        }
        return false;
    }

    void resize() {
        size *= 2;
        LinkedList<Integer>[] newHash = new LinkedList[size];
        reIndex(newHash);
        hash = newHash;
    }

    void reIndex(LinkedList<Integer>[] newHash) {
        int h;
        for (LinkedList<Integer> integers : hash) {
            if (integers == null || integers.isEmpty()) {
                continue;
            }
            for (int i = 0; i < integers.size(); i++) {
                Integer integer = integers.get(i);
                h = integer % size;

                LinkedList<Integer> list = newHash[h];

                if (list == null) {
                    LinkedList<Integer> newList = new LinkedList<>();
                    newList.add(integer);
                    newHash[h] = newList;
                } else {
                    if (!list.contains(integer)) {
                        list.add(integer);
                    }
                }
            }
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

