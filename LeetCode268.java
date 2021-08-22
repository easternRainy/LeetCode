public class LeetCode268 {
    public int missingNumber(int[] nums) {
        int result = nums.length;
        for(int i=0; i<nums.length; i++) {
            result = result ^ (i);
        }

        for(int i=0; i<nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
