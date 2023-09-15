/*
反转字符串中的元音字母
345
2023-09-15 10:24:29
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int l = s.length() - 1, i = 0;
        char tempChar;
        while (i < l) {
//            System.out.println(i);
//            System.out.println(l);
            for (; i < l; i++) {
                if (check(c[i])) {
                    break;
                }
            }
            for (; i < l; l--) {
                if (check(c[l])) {
                    break;
                }
            }
            if (i < l) {
                tempChar = c[i];
                c[i] = c[l];
                c[l] = tempChar;
                i++;
                l--;
            }
        }
        return String.valueOf(c);
    }

    boolean check(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
