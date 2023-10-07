// 开始时间：2023-10-07 10:24:53
// 题目标题：股票价格跨度
// 题目标记：online-stock-span
// 题目编号：901
// 题目描述：

import java.util.ArrayList;

/**
 * 设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 跨度 。
 * <p>
 * 当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * <p>
 * <p>
 * 例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。
 * <p>
 * <p>
 * 实现 StockSpanner 类：
 * <p>
 * <p>
 * StockSpanner() 初始化类对象。
 * int next(int price) 给出今天的股价 price ，返回该股票当日价格的 跨度 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：
 * ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
 * [[], [100], [80], [60], [70], [60], [75], [85]]
 * 输出：
 * [null, 1, 1, 1, 2, 1, 4, 6]
 * <p>
 * 解释：
 * StockSpanner stockSpanner = new StockSpanner();
 * stockSpanner.next(100); // 返回 1
 * stockSpanner.next(80);  // 返回 1
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(70);  // 返回 2
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(75);  // 返回 4 ，因为截至今天的最后 4 个股价 (包括今天的股价 75) 都小于或等于今天的股价。
 * stockSpanner.next(85);  // 返回 6
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= price <= 10⁵
 * 最多调用 next 方法 10⁴ 次
 * <p>
 * <p>
 * Related Topics 栈 设计 数据流 单调栈 👍 369 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class StockSpanner {

    Node<ArrayList<Integer>> dpHead;
    Node<ArrayList<Integer>> dpBack;

    public StockSpanner() {
        dpHead = new Node<>();
        dpBack = dpHead;
    }

    public int next(int price) {
        ArrayList<Integer> temp = new ArrayList<>(2);
        temp.add(price);
        temp.add(before(price));
        dpBack.val = temp;
        Node<ArrayList<Integer>> integerNode = new Node<>();
        integerNode.left = dpBack;
        dpBack.right = integerNode;
        dpBack = dpBack.right;
        return temp.get(1);
    }

    int before(int price) {
        Node<ArrayList<Integer>> temp = dpBack;
        int sum = 1;
        while (temp.left != null && temp.left.val.get(0) <= price) {
            sum += temp.left.val.get(1);
            for (int i = 0, l = temp.left.val.get(1); i < l; i++) {
                temp = temp.left;
            }
        }
        return sum;
    }

    static class Node<T> {
        T val;
        Node<T> left;
        Node<T> right;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
//leetcode submit region end(Prohibit modification and deletion)

