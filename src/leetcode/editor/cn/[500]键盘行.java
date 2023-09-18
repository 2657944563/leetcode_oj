import java.util.LinkedList;

/*
键盘行
500
2023-09-18 17:33:58
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findWords(String[] words) {
        String str1 = "qwertyuiop";
        String str2 = "asdfghjkl";
        String str3 = "zxcvbnm";
        LinkedList<String> result = new LinkedList<>();
        String target = null;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (word.length() == 1) {
                    result.add(word);
                    break;
                }
                char c = word.charAt(i);
                c = c < 'a' ? (char) (c + 32) : c;
                if (target == null) {
                    if (str1.indexOf(c) != -1) {
                        target = str1;
                    } else if (str2.indexOf(c) != -1) {
                        target = str2;
                        continue;
                    } else if (str3.indexOf(c) != -1) {
                        target = str3;
                    }
                    continue;
                } else if (target.indexOf(c) == -1) {
                    break;
                } else if (i == word.length() - 1) {
                    result.add(word);
                    break;
                }
            }
            target = null;
        }
        return result.toArray(String[]::new);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
