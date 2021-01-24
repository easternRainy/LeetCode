/**
 * Tags: #DynamicProgramming
 */
public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        if (m==1 && n==1) {
            return 1;
        }

        if (m==1 || n==1) {
            return 1;
        }

        int[][] result = new int[m][n];
        for(int j=0; j<n; j++) {
            result[m-1][j] = 1;
        }

        for(int i=0; i<m; i++) {
            result[i][n-1] = 1;
        }

        for(int i=m-2; i>=0; i--) {
            for(int j=n-2; j>=0; j--) {
                result[i][j] = result[i+1][j] + result[i][j+1];
            }
        }

        return result[0][0];
    }
}
