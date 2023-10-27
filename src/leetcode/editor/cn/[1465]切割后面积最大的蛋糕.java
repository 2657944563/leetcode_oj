// 开始时间：2023-10-27 09:38:08
// 题目标题：切割后面积最大的蛋糕
// 题目标记：maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts
// 题目编号：1465
// 题目描述：

import java.util.Arrays;

/**
 * 矩形蛋糕的高度为 h 且宽度为 w，给你两个整数数组 horizontalCuts 和 verticalCuts，其中：
 * <p>
 * <p>
 * horizontalCuts[i] 是从矩形蛋糕顶部到第 i 个水平切口的距离
 * verticalCuts[j] 是从矩形蛋糕的左侧到第 j 个竖直切口的距离
 * <p>
 * <p>
 * 请你按数组 horizontalCuts 和 verticalCuts 中提供的水平和竖直位置切割后，请你找出 面积最大 的那份蛋糕，并返回其 面积 。由于答
 * 案可能是一个很大的数字，因此需要将结果 对 10⁹ + 7 取余 后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
 * 输出：4
 * 解释：上图所示的矩阵蛋糕中，红色线表示水平和竖直方向上的切口。切割蛋糕后，绿色的那份蛋糕面积最大。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
 * 输出：6
 * 解释：上图所示的矩阵蛋糕中，红色线表示水平和竖直方向上的切口。切割蛋糕后，绿色和黄色的两份蛋糕面积最大。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
 * 输出：9
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= h, w <= 10⁹
 * 1 <= horizontalCuts.length <= min(h - 1, 10⁵)
 * 1 <= verticalCuts.length <= min(w - 1, 10⁵)
 * 1 <= horizontalCuts[i] < h
 * 1 <= verticalCuts[i] < w
 * 题目数据保证 horizontalCuts 中的所有元素各不相同
 * 题目数据保证 verticalCuts 中的所有元素各不相同
 * <p>
 * <p>
 * Related Topics 贪心 数组 排序 👍 58 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int[] hor = new int[horizontalCuts.length + 2];
        hor[hor.length - 1] = h;
        hor[0] = 0;
        System.arraycopy(horizontalCuts, 0, hor, 1, horizontalCuts.length);
        int[] vertical = new int[verticalCuts.length + 2];
        vertical[vertical.length - 1] = w;
        vertical[0] = 0;
        System.arraycopy(verticalCuts, 0, vertical, 1, verticalCuts.length);
        long maxX = 0;
        long maxY = 0;
        for (int i = 0; i < hor.length - 1; i++) {
            maxX = Math.max(maxX, hor[i + 1] - hor[i]);
        }
        for (int i = 0; i < vertical.length - 1; i++) {
            maxY = Math.max(maxY, vertical[i + 1] - vertical[i]);
        }
        return (int) (maxY * maxX % 1000000007) % 1000000007;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

