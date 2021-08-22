      
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        # print(s)
                
        def wordBreakIndex(s, wordDict, start_index):
            if start_index == len(s):
                return True
            
            for end_index in range(start_index+1, len(s)+1):
                if s[start_index:end_index] in wordDict and wordBreakIndex(s, wordDict, end_index):
                    return True
                
            return False
        
        return wordBreakIndex(s, wordDict, 0)
            
            
            
            
            