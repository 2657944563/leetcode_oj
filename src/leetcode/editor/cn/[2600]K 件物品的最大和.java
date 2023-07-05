/*
K 件物品的最大和
2600
2023-07-05 14:15:29
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k < numOnes) {
            return k;
        } else if (k < numOnes + numZeros) {
            return numOnes;
        } else {
            return numOnes - k + numOnes + numZeros;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
