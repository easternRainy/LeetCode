import java.util.Arrays;


/**
 * Hint: https://tenderleo.gitbooks.io/leetcode-solutions-/content/GoogleEasy/198.html
 * ```
 * while robbing i-th house, the max value is either rob the i-th house and the max value BEFORE the previous houses, or don't rob i-th house, and max value of robbing all previous houses
 *
 * ```
 *
 *
 * Tags: #DynamicProgramming
 */
public class LeetCode198 {
    public int rob_recursion(int[] nums) {
        if (nums.length == 0) { return 0; }

        if (nums.length == 1) { return nums[0]; }

        // find the last elemetn
        int last = nums[nums.length-1];
        int include_last = last + rob_recursion(Arrays.copyOfRange(nums, 0, nums.length-2));
        int not_include_last = rob_recursion(Arrays.copyOfRange(nums, 0, nums.length-1));

        return Math.max(include_last, not_include_last);

    }

    public int rob_dp(int[] nums) {
        if (nums.length == 0) { return 0; }

        if (nums.length == 1) { return nums[0]; }

        int[] results = new int[nums.length];
        for (int i=0; i<results.length; i++) {
            if (i==0) {
                results[i] = nums[i];
                continue;
            }

            if (i==1) {
                results[i] = Math.max(results[0], nums[i]);
                continue;
            }

            int include_curr = nums[i] + results[i-2];
            int not_include_curr = results[i-1];

            results[i] = Math.max(include_curr, not_include_curr);

        }

        return results[results.length-1];
    }

    public int rob_dp_storage_optimized(int[] nums) {
        if (nums.length == 0) { return 0; }

        if (nums.length == 1) { return nums[0]; }

        int first = nums[0];
        int second = Math.max(first, nums[1]);
        int curr = second;
        for (int i=2; i<nums.length; i++) {

            int include_curr = nums[i] + first;
            int not_include_curr = second;

            curr = Math.max(include_curr, not_include_curr);
            first = second;
            second = curr;

        }

        return curr;

    }

}
