/*
字符串相加
415
2023-09-09 21:36:05
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int n = num1.length() - num2.length();
        for (int length = num1.length() - 1; length >= 0; length--) {
            if (length < n) {
                result.insert(0, (num1.charAt(length) - '0' + i) % 10);
                i = (num1.charAt(length) - '0' + i) / 10;
            } else {
                result.insert(0, (num1.charAt(length) + num2.charAt(length - n) - '0' - '0' + i) % 10);
                i = (num1.charAt(length) + num2.charAt(length - n) - '0' - '0' + i) / 10;
            }
        }
        if (i != 0) {
            result.insert(0, i);
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
