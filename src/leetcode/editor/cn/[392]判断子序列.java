/*
判断子序列
392
2023-09-14 17:12:12
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = -1;
        final char[] chars = s.toCharArray();
        for (char aChar : chars) {
            i = t.indexOf(aChar, i + 1);
            if (i == -1) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
