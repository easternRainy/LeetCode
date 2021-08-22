class Solution:
    def maxArea(self, h: int, w: int, horizontalCuts: List[int], verticalCuts: List[int]) -> int:
        
        
        def max_dist(max_num, alist):
            """
            append 0 and max_num at the beginning and ending of alist
            return the max distance between two elements
            """
            alist = sorted(alist)
            list_tmp = [0] + alist + [max_num]
            print(list_tmp)
            max_dist = max([a-b for a, b in zip(list_tmp[1:], list_tmp[:-1])])
            return max_dist
        
        h_max = max_dist(h, horizontalCuts)
        w_max = max_dist(w, verticalCuts)
        
        return (int)((h_max * w_max) % (1e9+7))
        