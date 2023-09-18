/*
反转字符串 II
541
2023-09-18 18:12:45
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder();
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (str1.length() < k) {
                str1.append(s.charAt(i));
            } else {
                str2.append(s.charAt(i));
                if ((i + 1) % (k * 2) == 0 && i + 1 >= 2 * k) {
                    result.append(str1.reverse()).append(str2);
                    str1 = new StringBuilder();
                    str2 = new StringBuilder();
                }
            }
        }
        if (str1.length() > 0) {
            result.append(str1.reverse()).append(str2);
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
