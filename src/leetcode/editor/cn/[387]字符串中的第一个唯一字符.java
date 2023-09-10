import java.util.HashMap;

/*
字符串中的第一个唯一字符
387
2023-09-10 22:41:54
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        int min = s.length(), t;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer c = hashMap.get(s.charAt(i));
            if (c == null) {
                hashMap.put(s.charAt(i), i);
            } else {
                hashMap.put(s.charAt(i), -1);
            }
        }
        for (Character character : hashMap.keySet()) {
            t = hashMap.get(character);
            if (t != -1) {
                min = Math.min(min, t);
            }
        }
        return min == s.length() ? -1 : min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
