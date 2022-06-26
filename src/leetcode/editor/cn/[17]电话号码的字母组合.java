class Solution {
    String[] strs = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if (digits.isEmpty()) {
            return list;
        }
        if (digits.length() == 1) {
            char c = digits.charAt(0);
            String s = strs[c - '2'];
            for (int i = 0; i < s.length(); i++) {
                list.add(String.valueOf(s.charAt(i)));
            }
            return list;
        }
        List<String> strings = letterCombinations(digits.substring(1, digits.length()));
        char c = digits.charAt(0);
        String s = strs[c - '2'];
        for (int i = 0; i < s.length(); i++) {
            for (String string : strings) {
                list.add(s.charAt(i) + string);
            }
        }
        return list;
    }
}