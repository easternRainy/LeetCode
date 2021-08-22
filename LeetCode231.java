public class LeetCode231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) { return false; }
        if (n == 1) { return true; }

        long x = n;
        return ((-x) & x) == x;
    }
}
