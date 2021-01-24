public class LeetCode136 {
    public int singleNumber(int[] nums) {
        // list comprehension
        // sum(2*set) - sum(list)
        // hashtable

        // bit manipulation
        int result = 0;
        for (int i=0; i<nums.length; i++) {
            result = result ^ nums[i];
        }

        return result;

    }
}
