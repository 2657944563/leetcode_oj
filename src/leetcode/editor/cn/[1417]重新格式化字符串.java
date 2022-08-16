import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;

/*
重新格式化字符串
1417
2022-08-11 09:34:36
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reformat(String s) {
        StringBuilder num = new StringBuilder();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' & s.charAt(i) <= '9') {
                num.append(s.charAt(i));
            } else {
                str.append(s.charAt(i));
            }
        }
        if (Math.abs(num.length() - str.length()) > 1) {
            return "";
        } else {
            StringBuilder res = new StringBuilder();
            if (num.length() > str.length()) {
                for (int i = 0; i < num.length(); i++) {
                    res.append(num.charAt(i));
                    if (i < str.length()) {
                        res.append(str.charAt(i));
                    }
                }
            } else {
                for (int i = 0; i < str.length(); i++) {
                    res.append(str.charAt(i));
                    if (i < num.length()) {
                        res.append(num.charAt(i));
                    }
                }
            }
            return res.toString();
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
