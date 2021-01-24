/**
 * 2020-08-18
 * LeetCode Problem 1143
 * https://leetcode.com/problems/longest-common-subsequence/
 *
 * Tags: #Dynamic_Programming
 */
public class LeetCode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        /**
         * using dynamic programming tabulation method.
         * If the last chars of text1 and text2 are the same, then return longestCommonSubsequence(text1-lastChar, text2-lastChar) + 1.
         * Else, return max of LSS(text1-lastChar, text2) and LSS(text1, text2-lastChar)
         */

        int l1 = text1.length();
        int l2 = text2.length();

        // create the table
        int[][] table = new int[l1+1][l2+1];

        // let table[0][:] and table[:][0] zero since index 0 represents vacant string: ""
        for(int i=0; i<l1+1; i++) {
            table[i][0] = 0;
        }

        for(int j=0; j<l2+1; j++) {
            table[0][j] = 0;
        }

        for(int i=1; i<l1+1; i++) {
            for (int j=1; j<l2+1; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    table[i][j] = table[i-1][j-1] + 1;
                } else {
                    table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
                }
            }
        }

        return table[l1][l2];
    }



    public static void main(String[] args) {
        LeetCode1143 problem = new LeetCode1143();
        System.out.println(problem.longestCommonSubsequence("abcde", "ace"));
    }
}
