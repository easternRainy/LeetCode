class Solution1:
    # brute force

    def kthFactor(self, n: int, k: int) -> int:
        result = -1
        count = 0
        
        for i in range(1, sqrt(n)):
            
            if i > (n/2):
                # check n itself directly
                i = n
                count += 1
                
                if count == k:
                    return i
                else:
                    break
            
            if n % i == 0:
                count += 1
                
                if count == k:
                    return i
                
        return result


class Solution2:
    def kthFactor(self, n: int, k: int) -> int:
        divisors = []
        pair_divisors = []
        count = 0
        
        # https://stackoverflow.com/questions/38806964/number-of-factors-of-n-that-are-less-than-square-root-of-n
        
        ends = int(sqrt(n))
        for i in range(1, ends+1):
            if i*i == n:
                divisors.append(i)
                break
            
            if n % i == 0:
                divisors.append(i)
                pair_divisors.append(int(n/i))
                count += 1
                
                if count == k:
                    return i
        
        
            
        divisors.extend(pair_divisors[::-1])
        
        print(divisors)
        print(pair_divisors)
        if len(divisors) >= k:
            return divisors[k-1]
        else:
            return -1
        