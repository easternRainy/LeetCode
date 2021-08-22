/**
 * Tagas: #DynamicProgramming
 */
public class LeetCode509 {
    public int fib(int N) {
        if (N==0) {
            return 0;
        }

        if (N==1) {
            return 1;
        }

        int N_2 = 0;
        int N_1 = 1;
        int f_N = 0;
        for(int i=2; i<=N; i++) {
            f_N = N_2 + N_1;
            N_2 = N_1;
            N_1 = f_N;
        }

        return f_N;
    }

}
