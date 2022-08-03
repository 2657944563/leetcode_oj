/*
二维数组中的查找
剑指 Offer 04
2022-07-31 11:09:53
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = matrix.length - 1; i >= 0; i--) {
            if (target >= matrix[i][0]) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (target == matrix[i][j]) {
                        return true;
                    }
                    if (target < matrix[i][j]) {
                        break;
                    }
                }
            }
        }
        System.out.println("False");
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
