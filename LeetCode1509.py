class Solution:
    def minDifference(self, nums: List[int]) -> int:
        # Good Question!
        if len(nums) <= 4:
            return 0
        
        nums = sorted(nums)
        min_n = max(nums) - min(nums)
        
        min_n = min(nums[-1]-nums[3], min_n)
        min_n = min(nums[-2]-nums[2], min_n)
        min_n = min(nums[-3]-nums[1], min_n)
        min_n = min(nums[-4]-nums[0], min_n)
        
        return min_n