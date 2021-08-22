public class LeetCode977 {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int k = j;
        int[] result = new int[nums.length];
        while(i < nums.length && nums[i] < 0 && k >= 0) {
            if (Math.abs(nums[i]) < Math.abs(nums[j])) {
                result[k] = nums[j] * nums[j];
                j--;
            } else {
                result[k] = nums[i] * nums[i];
                i++;
            }
            k--;
        }

        while(k >= 0) {
            result[k] = nums[j] * nums[j];
            k--;
            j--;
        }

        return result;
    }
}
