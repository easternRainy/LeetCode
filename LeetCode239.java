public class LeetCode239 {
    /**
     * I want better solution
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int result[] = new int[nums.length - k + 1];

        int p1 = 0;
        int p2 = p1 + k - 1;
        int max = findMax(nums, p1, p2);

        result[0] = max;

        for(int i=1; i<=nums.length-k; i++) {
            p1 = i;
            p2 = p1 + k - 1;

            if (nums[p2] >= max) {
                max = nums[p2];
            } else {
                if (nums[i-1] == max) {
                    max = findMax(nums, p1, p2);
                }
            }
            result[i] = max;
        }

        return result;
    }


    public int findMax(int[] nums, int p1, int p2) {
        int max = -100000;
        for (int i=p1; i<=p2; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return max;
    }
}
