
/*
黑名单中的随机数
710
2022-06-26 08:42:48
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int sz;
    Random random = new Random();

    Map<Integer, Integer> map = new HashMap<>();

    // [0, sz) 存放非黑名单的元素
// [sz, n) 存放黑名单的元素
    public Solution(int n, int[] blacklist) {
        sz = n - blacklist.length;
        // 首先为每一个黑名单内的元素占一个坑
        for (int b : blacklist) {
            map.put(b, -1);
        }
        // 从 [sz, n) 的最后一个元素开始往前存放
        int last = n - 1;
        for (int b : blacklist) {
            // b in [0, sz)
            if (b < sz) {
                // 如果在 [sz, n) 中已经有黑名单内的元素，即向前移动一步
                // 这就是上述占坑的作用
                while (map.containsKey(last)) last--;
                // 映射
                map.put(b, last);
                last--;
            }
        }
    }


    public int pick() {
        int index = random.nextInt(sz);
        if (map.containsKey(index)) {
            return map.get(index);
        }
        return index;
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
//leetcode submit region end(Prohibit modification and deletion)
