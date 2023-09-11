/*
温度转换
2469
2023-09-11 16:38:46
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] convertTemperature(double celsius) {
        double[] result = new double[2];
        result[0] = celsius + 273.15;
        result[1] = celsius * 1.8 + 32.0;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
