class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        result = -1
        left_sum = 0
        right_sum = sum(nums)
        
        for i, num in enumerate(nums):
            left_sum += nums[i-1] if i > 0 else left_sum
            right_sum -= num if i < len(nums)-1 else right_sum
            
            if left_sum == right_sum:
                return i
        
        
        return result