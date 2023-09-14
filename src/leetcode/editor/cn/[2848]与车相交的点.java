import java.util.List;

/*
与车相交的点
2848
2023-09-14 21:47:25
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] result = new int[101];
        for (List<Integer> num : nums) {
            for (int i = num.get(0); i <= num.get(1); i++) {
                result[i] = 1;
            }
        }
        int sum = 0;
        for (int i : result) {
            if (i == 1) sum++;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
