/*
计算列车到站时间
2651
2023-09-08 09:16:04
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
