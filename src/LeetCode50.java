public class LeetCode50 {
    /**
     * fast power
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long N = n;
        if ( N < 0 ) {
            x = 1/x;
            N = -N;
        }

        return fastPower(x, N);
    }

    public double fastPower(double x, long n) {
        if (n == 0) {
            return 1;
        }

        double half = fastPower(x, n/2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
}
