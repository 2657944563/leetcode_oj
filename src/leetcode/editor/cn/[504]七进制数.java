/*
七进制数
504
2023-09-18 17:55:57
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToBase7(int num) {
        String flag = "";
        StringBuilder result = new StringBuilder();
        if (num < 0) {
            flag = "-";
            num = num * -1;
        }
        do {
            int i = num % 7;
            num /= 7;
            result.insert(0, i);
        } while (num > 0);
        return flag + result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
