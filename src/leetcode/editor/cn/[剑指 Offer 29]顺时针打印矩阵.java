/*
顺时针打印矩阵
剑指 Offer 29
2022-08-02 10:16:33
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int down = 0, left = 0, right = matrix[0].length - 1, up = matrix.length - 1, n = 0;
        int[] res = new int[(right + 1) * (up + 1)];
        while (up >= down && right >= left) {
            for (int i = left; i <= right; i++) {
                res[n++] = matrix[down][i];
            }
            if (down++ >= up) {
                break;
            }
            for (int i = down; i <= up; i++) {
                res[n++] = matrix[i][right];
            }
            if (right-- <= left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res[n++] = matrix[up][i];
            }
            if (up-- <= down) {
                break;
            }
            for (int i = up; i >= down; i--) {
                res[n++] = matrix[i][left];
            }
            if (left++ >= right) {
                break;
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
