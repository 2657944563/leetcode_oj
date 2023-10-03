// 开始时间：2023-10-03 12:14:41
// 题目标题：翻转图像
// 题目标记：flipping-an-image
// 题目编号：832
// 题目描述：

/**
 * 给定一个
 * n x n 的二进制矩阵 image ，先 水平 翻转图像，然后 反转 图像并返回 结果 。
 * <p>
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。
 * <p>
 * <p>
 * 例如，水平翻转 [1,1,0] 的结果是 [0,1,1]。
 * <p>
 * <p>
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。
 * <p>
 * <p>
 * 例如，反转 [0,1,1] 的结果是 [1,0,0]。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：image = [[1,1,0],[1,0,1],[0,0,0]]
 * 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * n == image.length
 * n == image[i].length
 * 1 <= n <= 20
 * images[i][j] == 0 或 1.
 * <p>
 * <p>
 * Related Topics 数组 双指针 矩阵 模拟 👍 306 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j <= image[i].length / 2; j++) {
                if (j > image.length - j - 1) {
                    break;
                } else if (j == image.length - j - 1) {
                    image[i][j] ^= 1;
                    break;
                }
                image[i][j] ^= image[i][image.length - j - 1];
                image[i][image.length - j - 1] ^= image[i][j];
                image[i][j] ^= image[i][image.length - j - 1];
                image[i][j] ^= 1;
                image[i][image.length - j - 1] ^= 1;
            }
        }
        return image;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

