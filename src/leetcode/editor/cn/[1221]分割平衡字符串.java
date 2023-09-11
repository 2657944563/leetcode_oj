/*
分割平衡字符串
1221
2023-09-11 11:52:43
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int balancedStringSplit(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int ans = 0;
        for (int i = 0; i < n; ) {
            int j = i + 1, score = cs[i] == 'L' ? 1 : -1;
            while (j < n && score != 0) score += cs[j++] == 'L' ? 1 : -1;
            i = j;
            ans++;
        }
        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
