class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 1, r = num / 2, mid;
        long s;
        while (l <= r) {
            mid = l + (r - l) / 2;
            s = (long) mid * mid;
            if (num == s) {
                return true;
            }
            if (s < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return num == 1;
    }
}

//runtime:0 ms
//memory:38 MB
