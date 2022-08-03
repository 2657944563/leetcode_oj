
/*
分数加减运算
592
2022-07-27 15:55:43
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String fractionAddition(String expression) {
        int[] num = new int[]{0, 0};
        byte[] bytes = expression.getBytes();
        // true = + false = -
        boolean flag = true;
        for (int i = 0; i < bytes.length; i++) {
            if (num[0] == 0 || num[1] == 0) {
                boolean F = true;
                if (bytes[i] == '-') {
                    i++;
                    F = false;
                }
                while (i < bytes.length && bytes[i] >= '0' && bytes[i] <= '9') {
                    num[0] = num[0] * 10 + bytes[i] - '0';
                    i++;
                }
                num[0] = F ? num[0] : num[0] * 1;
                i++;
                while (i < bytes.length && bytes[i] >= '0' && bytes[i] <= '9') {
                    num[1] = num[1] * 10 + bytes[i] - '0';
                    i++;
                }
                if (num[0] != 0 && num[1] != 0) {
                    int G = maxGongYingShu(num[0], num[1]);
                    num[0] /= G;
                    num[1] /= G;
                } else {
                    continue;
                }
            }
            if (i < bytes.length && bytes[i] == '+') {
                flag = true;
            } else if (i < bytes.length && bytes[i] == '-') {
                flag = false;
            }
            int a = 0, b = 0;
            while (i < bytes.length && bytes[i] >= '0' && bytes[i] <= '9') {
                a = a * 10 + bytes[i] - '0';
                i++;
            }
//            进行符号变更
            a = flag ? a : a * -1;
            i++;
            while (i < bytes.length && bytes[i] >= '0' && bytes[i] <= '9') {
                b = b * 10 + bytes[i] - '0';
                i++;
            }
            int gys = maxGongYingShu(b, num[1]);
            int gbs = minGongBeiShu(b, num[1]);
            a = num[1] / gys * a;
            num[0] = b / gys * num[0];
            b = num[1] = gbs;
//                分子进行加减去
            num[0] += a;
//                如果num变成0
//            化简,分子0就不必要化简了
            if (num[0] != 0) {
                int G = maxGongYingShu(num[0], num[1]);
                num[0] /= G;
                num[1] /= G;
            }
        }

        return num[0] + "/" + num[1];
    }


    int maxGongYingShu(int a, int b) {
//        System.out.println("a:" + a +"\tb:" + b);
        int t = a;
        if (a < b) {
            a = b;
            b = t;
        }
        while (a % b != 0) {
            System.out.println("a:" + a + "\tb:" + b);
            t = b;
            b = a % b;
            a = t;
        }
        return b;
    }

    int minGongBeiShu(int a, int b) {
        int gongYingShu = maxGongYingShu(a, b);
        a = a / gongYingShu;
        b = b / gongYingShu;
        return a * b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
