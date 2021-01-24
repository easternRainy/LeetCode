public class LeetCode528 {
    private int[] sums;
    private int totalSum;

    public LeetCode528(int[] w) {
        int n = w.length;
        int total = 0;
        this.sums = new int[n];

        for(int i=0; i<n; i++) {
            total += w[i];
            this.sums[i] = total;
        }

        this.totalSum = total;
    }

    public int pickIndex() {
        double target = this.totalSum * Math.random();

        int i = 0;
        int j = this.sums.length;

        while(i < j) {
            int mid = (i + j) / 2;
            if (this.sums[mid] >= target) {
                j = mid;

            } else {
                i = mid + 1;

            }
        }

        return i;

    }
}
