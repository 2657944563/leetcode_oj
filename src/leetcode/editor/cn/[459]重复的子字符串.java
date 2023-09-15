/*
重复的子字符串
459
2023-09-15 11:03:21
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String temp = s + s;
        temp = temp.substring(1, temp.length() - 1);
        if (temp.indexOf(s) > -1) {
            return true;
        }
        return false;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
