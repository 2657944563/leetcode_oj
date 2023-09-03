import java.util.Arrays;

/*
消灭怪物的最大数量
1921
2023-09-03 15:43:34
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] result = new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            int d = dist[i] % speed[i];
            int s = dist[i] / speed[i] + (d == 0 ? 0 : 1);
            result[i] = s;
        }
        // 对需要战斗的时间进行排序
        Arrays.sort(result);
        // 拥有的子弹 每回合+1
        int k = 0, start = 0, i;
        for (i = 0; i < result.length; i++) {
            k += result[i] - start;
            if (k <= 0) {
                break;
            } else {
                k--;
                start = result[i];
            }
        }
        return i;
    }

    // 超时
    int baoli(int[] dist, int[] speed) {
        // 先消灭再判断
        // i 表示 度过的分钟
        // k 表示 空闲度过的分钟 k/2 == 可以避免死亡的次数
        //如果 k<0并且有dist[n]-dist[n]*i<0即怪兽到脸上了，那么就解决不了了

        int i = 0, k = 0, result = 0;
        // 这分钟需要击杀的怪兽
        int t = 0;
        do {
            for (int j = 0; j < dist.length; j++) {
                // -1表示当前怪物已经进入统计
                if (dist[j] != -1 && dist[j] <= speed[j] * (i + 1)) {
                    t++;
                    dist[j] = -1;
                }
            }
            // 普通杀敌
            if (t == 1) {
                result++;
                t = 0;
                continue;
            }

            // 如果前面没有提前开枪
            if (t - 1 > k) {
                // 之前杀的 + 这回合 + 空过的回合
                return result + 1 + k;
            }
            // 空过一回合
            k = k - t + 1;
            result += t;
            t = 0;
            if (result == dist.length) {
                break;
            }
        } while (++i > 0);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
