/*
字符串中的单词数
434
2023-09-15 10:11:47
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSegments(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        int sum = 0, index = s.indexOf(' ');
        while (index != -1) {
            sum++;
            s = s.substring(index);
            s = s.trim();
            index = s.indexOf(' ');
        }
        return sum + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
