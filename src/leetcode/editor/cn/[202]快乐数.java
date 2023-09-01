import java.util.HashSet;

/*
快乐数
202
2023-09-01 17:56:24
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
        long happy = n;
        HashSet<Long> set = new HashSet<>(32);
        while (happy != 1) {
            happy = happy(happy);
            if (!set.add(Long.valueOf(happy))) {
                return false;
            }
        }
        return true;
    }

    long happy(long n) {
        long res = 0;
        while (n > 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
