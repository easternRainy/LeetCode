class Solution:
    def climbStairs(self, n: int) -> int:
        if n < 3:
            return n
        else:
            i = 1
            j = 2
            result = 0
            for k in range(3, n+1):
                result = i + j
                i = j
                j = result
            return result