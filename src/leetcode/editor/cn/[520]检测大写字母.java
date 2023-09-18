/*
检测大写字母
520
2023-09-18 18:02:10
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean detectCapitalUse(String word) {
        String str = word.toLowerCase();
        if (str.equals(word)) {
            return true;
        } else if (word.equals(str.toUpperCase())) {
            return true;
        } else if ((str.substring(0, 1).toUpperCase() + str.substring(1)).equals(word)) {
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
