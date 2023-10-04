// 开始时间：2023-10-04 15:34:53
// 题目标题：图像渲染
// 题目标记：flood-fill
// 题目编号：733
// 题目描述：

import java.util.HashSet;
import java.util.LinkedList;

/**
 * 有一幅以 m x n 的二维整数数组表示的图画 image ，其中 image[i][j] 表示该图画的像素值大小。
 * <p>
 * 你也被给予三个整数 sr , sc 和 newColor 。你应该从像素 image[sr][sc] 开始对图像进行 上色填充 。
 * <p>
 * 为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应
 * 四个方向上 像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为 newColor 。
 * <p>
 * 最后返回 经过上色渲染后的图像 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: image = [[1,1,1],[1,1,0],[1,0,1]]，sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析: 在图像的正中间，(坐标(sr,sc)=(1,1)),在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，因为它不是在上下左右四个方向上与初始点相连的像素点。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
 * 输出: [[2,2,2],[2,2,2]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * m == image.length
 * n == image[i].length
 * 1 <= m, n <= 50
 * 0 <= image[i][j], newColor < 2¹⁶
 * 0 <= sr < m
 * 0 <= sc < n
 * <p>
 * <p>
 * Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 475 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        HashSet<String> hashSet = new HashSet<>();
        LinkedList<int[]> list = new LinkedList<>();
        int target = image[sr][sc];
        list.add(new int[]{sr, sc});
        hashSet.add(sr + "" + sc);
        while (!list.isEmpty()) {
            int[] ints = list.removeFirst();
            image[ints[0]][ints[1]] = color;
            add(image, ints, list, hashSet, target);
        }
        return image;
    }

    void add(int[][] image, int[] ints, LinkedList<int[]> list, HashSet<String> hashSet, int target) {
        if (ints[0] > 0 && image[ints[0] - 1][ints[1]] == target
                && !hashSet.contains((ints[0] - 1) + "" + ints[1])) {
            list.add(new int[]{ints[0] - 1, ints[1]});
            hashSet.add((ints[0] - 1) + "" + ints[1]);
        }
        if (ints[0] < image.length - 1 && image[ints[0] + 1][ints[1]] == target
                && !hashSet.contains((ints[0] + 1) + "" + ints[1])) {
            list.add(new int[]{ints[0] + 1, ints[1]});
            hashSet.add((ints[0] + 1) + "" + ints[1]);
        }
        if (ints[1] > 0 && image[ints[0]][ints[1] - 1] == target
                && !hashSet.contains(ints[0] + "" + (ints[1] - 1))) {
            list.add(new int[]{ints[0], ints[1] - 1});
            hashSet.add(ints[0] + "" + (ints[1] - 1));
        }
        if (ints[1] < image[0].length - 1 && image[ints[0]][ints[1] + 1] == target
                && !hashSet.contains(ints[0] + "" + (ints[1] + 1))) {
            list.add(new int[]{ints[0], ints[1] + 1});
            hashSet.add(ints[0] + "" + (ints[1] + 1));
        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)

