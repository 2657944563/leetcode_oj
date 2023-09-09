import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
二进制手表
401
2023-09-09 20:26:13
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        LinkedList<Integer> sum = new LinkedList<>();
        dfs(sum, 10, turnedOn, 0);
        List<String> result = new ArrayList<>(sum.size());
        int h = 0, m = 0;
        for (Integer integer : sum) {
            h = integer >> 6;
            m = integer - (h << 6);
            if (h < 12 && m < 60) {
                result.add(h + ":" + (m < 10 ? "0" : "") + m);
            }
        }
        return result;
    }

    void dfs(LinkedList<Integer> sum, int n, int turnedOn, int temp) {
        if (n == 0) {
            if (turnedOn == 0) {
                sum.add(temp);
            }
            return;
        }
        temp <<= 1;
        n--;
        dfs(sum, n, turnedOn, temp);
        dfs(sum, n, --turnedOn, temp + 1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
