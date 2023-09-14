import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
可以攻击国王的皇后
1222
2023-09-14 12:47:02
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i = king[0] - 1; i >= 0; i--) {
            if (volite(queens, i, king[1])) {
                ArrayList<Integer> list = new ArrayList<>(2);
                list.add(i);
                list.add(king[1]);
                result.add(list);
                break;
            }
        }
        for (int i = king[0] + 1; i < 9; i++) {
            if (volite(queens, i, king[1])) {
                ArrayList<Integer> list = new ArrayList<>(2);
                list.add(i);
                list.add(king[1]);
                result.add(list);
                break;
            }
        }
        for (int i = king[1] + 1; i < 9; i++) {
            if (volite(queens, king[0], i)) {
                ArrayList<Integer> list = new ArrayList<>(2);
                list.add(king[0]);
                list.add(i);
                result.add(list);
                break;
            }
        }
        for (int i = king[1] - 1; i >= 0; i--) {
            if (volite(queens, king[0], i)) {
                ArrayList<Integer> list = new ArrayList<>(2);
                list.add(king[0]);
                list.add(i);
                result.add(list);
                break;
            }
        }
        for (int i = 1; king[0] + i < 9 && king[1] + i < 9; i++) {
            if (volite(queens, king[0] + i, king[1] + i)) {
                ArrayList<Integer> list = new ArrayList<>(2);
                list.add(king[0] + i);
                list.add(king[1] + i);
                result.add(list);
                break;
            }
        }
        for (int i = 1; king[0] - i >= 0 && king[1] - i >= 0; i++) {
            if (volite(queens, king[0] - i, king[1] - i)) {
                ArrayList<Integer> list = new ArrayList<>(2);
                list.add(king[0] - i);
                list.add(king[1] - i);
                result.add(list);
                break;
            }
        }
        for (int i = 1; king[0] - i >= 0 && king[1] + i < 9; i++) {
            if (volite(queens, king[0] - i, king[1] + i)) {
                ArrayList<Integer> list = new ArrayList<>(2);
                list.add(king[0] - i);
                list.add(king[1] + i);
                result.add(list);
                break;
            }
        }
        for (int i = 1; king[0] + i < 9 && king[1] - i >= 0; i++) {
            if (volite(queens, king[0] + i, king[1] - i)) {
                ArrayList<Integer> list = new ArrayList<>(2);
                list.add(king[0] + i);
                list.add(king[1] - i);
                result.add(list);
                break;
            }
        }
        return result;
    }

    boolean volite(int[][] queens, int i, int l) {
        for (int[] queen : queens) {
            if (queen[0] == i && queen[1] == l) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
