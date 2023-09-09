import java.util.HashMap;

/*
有效的字母异位词
242
2023-09-09 20:20:52
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.merge(c, 1, Integer::sum);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer integer = map.get(c);
            if (integer == null) {
                return false;
            } else {
                if (integer == 1) {
                    map.remove(c);
                } else {
                    map.put(c, integer - 1);
                }
            }
        }
        return map.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
