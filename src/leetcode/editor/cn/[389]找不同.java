import java.util.HashMap;

/*
找不同
389
2023-09-07 18:27:57
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char findTheDifference(String s, String t) {

        HashMap<Character, Integer> s1 = new HashMap<>(s.length());
        char b;
        for (int i = 0; i < s.length(); i++) {
            b = s.charAt(i);
            s1.merge(b, 1, Integer::sum);
        }
        for (int i = 0; i < t.length(); i++) {
            b = t.charAt(i);
            Integer l = s1.get(b);
            if (l == null || l == 0) {
                return b;
            } else {
                s1.put(b, l - 1);
            }
        }
        return 'c';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
