// 开始时间：2023-12-16 13:30:10
// 题目标题：统计区间中的整数数目
// 题目标记：count-integers-in-intervals
// 题目编号：2276
// 题目描述：

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 给你区间的 空 集，请你设计并实现满足要求的数据结构：
 * <p>
 * <p>
 * 新增：添加一个区间到这个区间集合中。
 * 统计：计算出现在 至少一个 区间中的整数个数。
 * <p>
 * <p>
 * 实现 CountIntervals 类：
 * <p>
 * <p>
 * CountIntervals() 使用区间的空集初始化对象
 * void add(int left, int right) 添加区间 [left, right] 到区间集合之中。
 * int count() 返回出现在 至少一个 区间中的整数个数。
 * <p>
 * <p>
 * 注意：区间 [left, right] 表示满足 left <= x <= right 的所有整数 x 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入
 * ["CountIntervals", "add", "add", "count", "add", "count"]
 * [[], [2, 3], [7, 10], [], [5, 8], []]
 * 输出
 * [null, null, null, 6, null, 8]
 * <p>
 * 解释
 * CountIntervals countIntervals = new CountIntervals(); // 用一个区间空集初始化对象
 * countIntervals.add(2, 3);  // 将 [2, 3] 添加到区间集合中
 * countIntervals.add(7, 10); // 将 [7, 10] 添加到区间集合中
 * countIntervals.count();    // 返回 6
 * // 整数 2 和 3 出现在区间 [2, 3] 中
 * // 整数 7、8、9、10 出现在区间 [7, 10] 中
 * countIntervals.add(5, 8);  // 将 [5, 8] 添加到区间集合中
 * countIntervals.count();    // 返回 8
 * // 整数 2 和 3 出现在区间 [2, 3] 中
 * // 整数 5 和 6 出现在区间 [5, 8] 中
 * // 整数 7 和 8 出现在区间 [5, 8] 和区间 [7, 10] 中
 * // 整数 9 和 10 出现在区间 [7, 10] 中
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= left <= right <= 10⁹
 * 最多调用 add 和 count 方法 总计 10⁵ 次
 * 调用 count 方法至少一次
 * <p>
 * <p>
 * Related Topics 设计 线段树 有序集合 👍 70 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class CountIntervals {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int cnt = 0;

    public CountIntervals() {

    }

    public void add(int left, int right) {
        Map.Entry<Integer, Integer> interval = map.floorEntry(right);
        while (interval != null && interval.getValue() >= left) {
            int l = interval.getKey(), r = interval.getValue();
            left = Math.min(left, l);
            right = Math.max(right, r);
            cnt -= r - l + 1;
            map.remove(l);
            interval = map.floorEntry(right);
        }
        cnt += (right - left + 1);
        map.put(left, right);
    }

    public int count() {
        return cnt;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */
//leetcode submit region end(Prohibit modification and deletion)

