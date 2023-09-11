/*
替换隐藏数字得到的最晚时间
1736
2023-09-11 11:34:23
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String maximumTime(String time) {
        String[] split = time.split(":");
        String result;
        int index = (split[0].indexOf("?"));
        if (split[0].equals("??")) {
            result = "23:";
        } else if (index == 0) {
            if (split[0].charAt(1) - '0' > 3) {
                result = "1" + split[0].charAt(1) + ":";
            } else {
                result = "2" + split[0].charAt(1) + ":";
            }
        } else if (index == 1) {
            if (split[0].charAt(0) - '0' > 1) {
                result = "23:";
            } else {
                result = split[0].charAt(0) + "9:";
            }
        } else {
            result = split[0] + ":";
        }
        index = (split[1].indexOf("?"));
        if (split[1].equals("??")) {
            result += "59";
        } else if (index == 0) {
            result += "5" + split[1].charAt(1);
        } else if (index == 1) {
            result += split[1].charAt(0) + "9";
        } else {
            result += split[1];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
