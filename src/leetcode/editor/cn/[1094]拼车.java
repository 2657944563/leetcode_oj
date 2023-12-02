// 开始时间：2023-12-02 15:20:20
// 题目标题：拼车
// 题目标记：car-pooling
// 题目编号：1094
// 题目描述：

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 * <p>
 * 给定整数 capacity 和一个数组 trips , trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有
 * numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 * <p>
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= trips.length <= 1000
 * trips[i].length == 3
 * 1 <= numPassengersi <= 100
 * 0 <= fromi < toi <= 1000
 * 1 <= capacity <= 10⁵
 * <p>
 * <p>
 * Related Topics 数组 前缀和 排序 模拟 堆（优先队列） 👍 324 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt(o -> o[1]));
        int n = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int[] trip : trips) {
            n += trip[0];
            if (n > capacity) {
                Integer[] list = hm.keySet().toArray(new Integer[0]);
                Arrays.sort(list);
                for (Integer integer : list) {
                    if (integer > trip[1]) {
                        break;
                    } else {
                        n -= hm.get(integer);
                        hm.remove(integer);
                    }
                }
                if (n > capacity) return false;
                // 减少
            }
            hm.merge(trip[2], trip[0], Integer::sum);
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

