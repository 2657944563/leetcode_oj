import java.util.HashMap;

/*
最长回文串
409
2023-09-10 22:26:15
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        int su = 0, t = 0;
        boolean a = true;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashMap.merge(s.charAt(i), 1, Integer::sum);
        }
        for (Character character : hashMap.keySet()) {
            t = hashMap.get(character);
            if (t % 2 == 1) {
                su = su + (a ? 1 : 0) + t - 1;
                a = false;
            } else {
                su += t;
            }
        }

        return su;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
