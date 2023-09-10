import java.util.Arrays;

/*
旋转图像
48
2023-09-10 12:40:22
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length, t;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix[i].length - 1 - i; j++) {
                t = matrix[i][j];
                matrix[i][j] ^= matrix[n - j - 1][i];
                matrix[n - j - 1][i] ^= matrix[i][j];
                matrix[i][j] ^= matrix[n - j - 1][i];
                //把该区域下面的点旋转到该区域
                matrix[n - j - 1][i] ^= matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] ^= matrix[n - j - 1][i];
                matrix[n - j - 1][i] ^= matrix[n - i - 1][n - j - 1];
                // 把该区域右下角的点旋转到该区域下面
                matrix[n - i - 1][n - j - 1] ^= matrix[j][n - i - 1];
                matrix[j][n - i - 1] ^= matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] ^= matrix[j][n - i - 1];
                // 把该区域右边的点旋转到该区域右下角
                matrix[j][n - i - 1] ^= t;
                t ^= matrix[j][n - i - 1];
                matrix[j][n - i - 1] ^= t;
            }
        }
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
