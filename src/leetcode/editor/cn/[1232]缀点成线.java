// 开始时间：2023-10-25 21:46:32
// 题目标题：缀点成线
// 题目标记：check-if-it-is-a-straight-line
// 题目编号：1232
// 题目描述：

/**
 * 给定一个数组 coordinates ，其中 coordinates[i] = [x, y] ，
 * [x, y] 表示横坐标为 x、纵坐标为 y 的点。请你来判断，这些点是否在该坐标系中属于同一条直线上。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates 中不含重复的点
 * <p>
 * <p>
 * Related Topics 几何 数组 数学 👍 141 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 1; i < coordinates.length; i++) {
            if (coordinates[i - 1][0] != coordinates[i][0]) {
                break;
            } else if (i == coordinates.length - 1) {
                return true;
            }
        }
        for (int i = 1; i < coordinates.length; i++) {
            if (coordinates[i - 1][1] != coordinates[i][1]) {
                break;
            } else if (i == coordinates.length - 1) {
                return true;
            }
        }
        double s = (double) (coordinates[0][0] - coordinates[1][0]) / (coordinates[0][1] - coordinates[1][1]);
        for (int i = 1; i < coordinates.length; i++) {
            if (coordinates[i - 1][0] == coordinates[i][0] ||
                    coordinates[i - 1][1] == coordinates[i][1]) {
                return false;
            }
            if ((double) (coordinates[i - 1][0] - coordinates[i][0]) /
                    (coordinates[i - 1][1] - coordinates[i][1]) != s) {
                return false;
            }
        }


        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

