import java.util.LinkedList;
import java.util.List;

/*
格雷编码
89
2023-09-15 17:33:07
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> grayCode(int n) {
        LinkedList<Integer> result = new LinkedList<>();
        result.add(0);
        result.add(1);
        for (int i = 1; i < n; i++) {
            LinkedList<Integer> temp = new LinkedList<>();
            temp.addAll(result);
            while (!result.isEmpty()) {
                int l = result.removeLast();
                l += Math.pow(2.0, i);
                temp.add(l);
            }
            result = temp;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
