public class LeetCode191 {
    public int hammingWeight(int n) {
        int num = 0;
        int mask = 1;
        for (int i=0; i<32; i++) {
            if ((n&mask) != 0) {
                System.out.println((n&mask));
                num++;
            }
            mask = mask << 1;
        }

        return num;
    }

    public int hammingWeightBit(int n) {
        int num = 0;
        while (n != 0) {
            n = n & (n-1);
            num++;
        }
        return num;

    }
}
