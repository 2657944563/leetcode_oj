import java.util.Arrays;

/*
分发饼干
455
2023-09-15 10:45:03
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, l = 0;
        while (i < g.length && l < s.length) {
            for (int j = l; j < s.length; j++) {
                if (s[j] >= g[i]) {
                    l = j + 1;
                    i++;
                    break;
                }
                if (j == s.length - 1) {
                    return i;
                }
            }
        }
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
