public class LeetCode1470 {
    /**
     * class Solution:
     *     def shuffle(self, nums: List[int], n: int) -> List[int]:
     *         a = nums[:n]
     *         b = nums[n:]
     *         result = []
     *         for i,j in zip(a,b):
     *             result.extend([i,j]) # really fast using "extend"
     *
     *         return result
     */
}
