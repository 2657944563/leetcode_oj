import java.util.HashMap;

/*
同构字符串
205
2023-09-02 11:53:09
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> sHash = new HashMap<>();
        HashMap<Character, Integer> tHash = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            boolean b1 = sHash.containsKey(c1);
            boolean b2 = tHash.containsKey(c2);
            if (b1 ^ b2) {
                return false;
            } else if (!b1) {
                sHash.put(c1, i);
                tHash.put(c2, i);
            } else if (!sHash.get(c1).equals(tHash.get(c2))) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
