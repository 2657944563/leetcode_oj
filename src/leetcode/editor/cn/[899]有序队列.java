import java.util.Arrays;

/*
有序队列
899
2022-08-03 21:47:26
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String orderlyQueue(String s, int k) {
        byte[] bytes = s.getBytes();
        if (k == 1) {
            byte min = 127;
            for (int i = 0; i < bytes.length; i++) {
                if (min > bytes[i]) {
                    min = bytes[i];
                }
            }
            String minString = s;
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] == min) {
                    String temp = s.substring(i) + s.substring(0, i);
                    if (temp.compareTo(minString) < 0) {
                        minString = temp;
                    }
                }
            }
            return minString;

        } else {
            Arrays.sort(bytes);
        }
        return new String(bytes);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
