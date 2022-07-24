/*
公交站间的距离
1184
2022-07-24 12:42:01
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0, min = Integer.MAX_VALUE;
        boolean flag = false;
        for (int i = start; ; i = (i + 1) % distance.length) {
            sum += distance[i];
            if (i == destination) {
                System.out.println("i:" + i + "sum = " + sum);
                flag = true;
                min = Math.min(sum - distance[i], min);
                sum = distance[i];
            }
            if (i == start && flag) {
                System.out.println("i:" + i + "sum = " + sum);
                min = Math.min(sum - distance[i], min);
                break;
            }
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
