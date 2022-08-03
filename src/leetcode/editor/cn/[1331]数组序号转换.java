import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
数组序号转换
1331
2022-07-28 16:36:46
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] res = new int[arr.length];
        HashMap<Integer, ArrayList<Integer>> hash = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!hash.containsKey(arr[i])) {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(i);
                hash.put(arr[i], integers);
                System.out.println("put:" + arr[i] + " 是:" + i);
                continue;
            }
            System.out.println("put:" + arr[i] + " 是:" + i);
            hash.get(arr[i]).add(i);
        }
        Arrays.sort(arr);
        int n = 1;
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> integers = hash.remove(arr[i]);
            if (integers == null) {
                continue;
            }
            System.out.println(integers.toString());
            for (Integer integer : integers) {
                res[integer] = n;
            }
            n++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
