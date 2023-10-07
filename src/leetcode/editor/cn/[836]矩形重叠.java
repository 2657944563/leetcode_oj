// 开始时间：2023-10-07 11:51:21
// 题目标题：矩形重叠
// 题目标记：rectangle-overlap
// 题目编号：836
// 题目描述：

/**
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。矩形的上下边平行于 x 轴，
 * 左右边平行于 y 轴。
 * <p>
 * 如果相交的面积为 正 ，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * <p>
 * 给出两个矩形 rec1 和 rec2 。如果它们重叠，返回 true；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：rec1 = [0,0,1,1], rec2 = [2,2,3,3]
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * rect1.length == 4
 * rect2.length == 4
 * -10⁹ <= rec1[i], rec2[i] <= 10⁹
 * rec1 和 rec2 表示一个面积不为零的有效矩形
 * <p>
 * <p>
 * Related Topics 几何 数学 👍 294 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int[] rec3 = new int[4];
        rec3[0] = Math.max(rec1[0], rec2[0]);
        rec3[1] = Math.max(rec1[1], rec2[1]);
        rec3[2] = Math.min(rec1[2], rec2[2]);
        rec3[3] = Math.min(rec1[3], rec2[3]);
        return rec3[2] > rec3[0] && rec3[3] > rec3[1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

