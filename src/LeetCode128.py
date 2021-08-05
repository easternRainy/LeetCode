class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        
        min_n, max_n = min(nums), max(nums)
        table = dict()
        
        for num in nums:
            table[num] = 1
          
        max_len = 0 
        current_len = 0
        
        nums = sorted(nums)
        while len(nums) > 0:
            p = nums[0]
            current_len += 1
            nums.remove(p)
            
            while True:
                p += 1
                if table.get(p) is not None:
                    current_len += 1
                    nums.remove(p)
                    del table[p]
                    # print(nums)
                else:
                    break
                    
            if current_len > max_len:
                max_len = current_len
            
            current_len = 0
        
        return max_len