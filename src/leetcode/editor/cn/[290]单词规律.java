import java.util.HashMap;

/*
单词规律
290
2023-09-07 18:38:52
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] t = s.split(" ");
        if (t.length != pattern.length()) {
            return false;
        }
        HashMap<Character, Integer> result1 = new HashMap<>(t.length);
        HashMap<String, Integer> result2 = new HashMap<>(t.length);
        for (int i = 0; i < pattern.length(); i++) {
            Integer integer1 = result1.get(pattern.charAt(i));
            Integer integer2 = result2.get(t[i]);
            if (integer1 == null && integer2 == null) {
                result1.put(pattern.charAt(i), i);
                result2.put(t[i], i);
            } else if (integer1 == null ^ integer2 == null
                    || !integer1.equals(integer2)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
