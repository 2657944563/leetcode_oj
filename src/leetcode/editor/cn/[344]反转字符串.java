/*
反转字符串
344
2023-09-07 18:09:51
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        char t;
        while (l < r) {
            t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
