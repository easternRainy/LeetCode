class Solution:
    def validPalindrome(self, s: str) -> bool:
        return self.validPalindrome_(s, 1)
    
    def validPalindrome_(self, s, tolerance):
        if tolerance < 0:
            return False
            
        
        
        i = 0
        j = len(s) - 1
        
        if j < i:
            return True
        
    
        if len(s) <= 1:
            return True
        
        
        
        if s[i] == s[j]:
            return self.validPalindrome_(s[i+1: j], tolerance)
        else:
            return self.validPalindrome_(s[i+1: j+1], tolerance-1) or \
                   self.validPalindrome_(s[i: j], tolerance-1)
        