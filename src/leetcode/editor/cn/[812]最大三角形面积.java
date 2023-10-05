// 开始时间：2023-10-04 20:26:28
// 题目标题：最大三角形面积
// 题目标记：largest-triangle-area
// 题目编号：812
// 题目描述：

/**
 * 给你一个由 X-Y 平面上的点组成的数组 points ，其中 points[i] = [xi, yi] 。从其中取任意三个不同的点组成三角形，返回能组成的最大
 * 三角形的面积。与真实值误差在 10⁻⁵ 内的答案将会视为正确答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出：2.00000
 * 解释：输入中的 5 个点如上图所示，红色的三角形面积最大。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：points = [[1,0],[0,0],[0,1]]
 * 输出：0.50000
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 3 <= points.length <= 50
 * -50 <= xi, yi <= 50
 * 给出的所有点 互不相同
 * <p>
 * <p>
 * Related Topics 几何 数组 数学 👍 191 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double largestTriangleArea(int[][] points) {
        double ans = 0;
        for (int[] p1 : points) {
            int x1 = p1[0], y1 = p1[1];
            for (int[] p2 : points) {
                int x2 = p2[0], y2 = p2[1];
                for (int[] p3 : points) {
                    int x3 = p3[0], y3 = p3[1];
                    ans = Math.max(ans, 0.5 * ((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)));
                }
            }
        }
        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

