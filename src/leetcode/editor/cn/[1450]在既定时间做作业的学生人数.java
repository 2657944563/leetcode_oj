/*
在既定时间做作业的学生人数
1450
2022-08-19 15:17:33
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int sum = 0;
        for (int i = 0; i < endTime.length; i++) {
            if (endTime[i] >= queryTime && startTime[i] <= queryTime) {
                sum++;
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
