/*
判断能否在给定时间到达单元格
2849
2023-09-14 21:52:55
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy && t == 1) return false;
        return t >= Math.max(Math.abs(sx - fx), Math.abs(sy - fy));
    }
}

//leetcode submit region end(Prohibit modification and deletion)
