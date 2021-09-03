class MaxStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.max_val = None
        self.stk = []
        

    def push(self, x: int) -> None:
        self.stk.append(x)
        
        if self.max_val is None:
            self.max_val = x
        
        if x > self.max_val:
            self.max_val = x

    def pop(self) -> int:
        if self.isEmpty():
            return None
        
        pop_val = self.stk.pop()
        
        if self.isEmpty():
            self.max_val = None
            
            return pop_val
        
        if pop_val == self.max_val:
            self.max_val = max(self.stk)
            
        return pop_val
        

    def top(self) -> int:
        if self.isEmpty():
            return None
        
        return self.stk[-1]

    
    def peekMax(self) -> int:
        return self.max_val

    def popMax(self) -> int:
        
        if self.isEmpty():
            return None
        
        max_idx = len(self.stk) - 1
        pop_idx = None
        for i in range(max_idx, -1, -1):
            if self.stk[i] == self.max_val:
                pop_idx = i
                break
                
        pop_val = self.stk.pop(pop_idx)
        
        
        if self.isEmpty():
            self.max_val = None
        else:
            self.max_val = max(self.stk)
            
        return pop_val
        
    def isEmpty(self) -> bool:
        return len(self.stk) == 0
        
        


# Your MaxStack object will be instantiated and called as such:
# obj = MaxStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.peekMax()
# param_5 = obj.popMax()