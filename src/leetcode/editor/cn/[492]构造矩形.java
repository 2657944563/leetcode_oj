/*
构造矩形
492
2023-09-18 17:05:37
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        for (; sqrt > 1; sqrt--) {
            if (area % sqrt == 0) {
                break;
            }
        }
        return new int[]{area / sqrt, sqrt};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
