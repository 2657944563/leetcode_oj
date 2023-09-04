import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/*
完成一半题目
LCS 02
2023-09-04 19:57:52
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int halfQuestions(int[] questions) {
        int n = questions.length / 2;
        HashMap<Integer, Integer> set = new HashMap(questions.length);
        for (int i = 0; i < questions.length; i++) {
            if (set.containsKey(questions[i])) {
                set.put(questions[i], set.get(questions[i]) + 1);
            } else {
                set.put(questions[i], 1);
            }
        }
        List<Integer> integers = set.keySet()
                .stream()
                .map(set::get)
                .sorted(Comparator.comparingInt(o -> -o))
                .collect(Collectors.toList());
        for (int i = 0; i < integers.size(); i++) {
            if ((n -= integers.get(i)) <= 0) {
                return i + 1;
            }
        }
        return questions.length / 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
