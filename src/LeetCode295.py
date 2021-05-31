class MedianFinder:
    
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.data = Node(float('-inf'))
        self.mid = None # points to the middle node
        self.n_elem = 0
        self.median = None
   
    def debug(self):
        p = self.data
        
        debug_str = ""
        while p is not None:
            debug_str += f"{p.data} -> "
            p = p.next
            
        
        return debug_str
        

    def addNum(self, num: int) -> None:
        new_node = Node(num)
        
        
        
        if self.mid is None:
            self.data.next = new_node
            self.mid = new_node
            self.median = num
            self.n_elem += 1
        else:
            p1 = self.data # back pointer
            p2 = p1 # front pointer
            while p2 is not None and p2.data < num:                
                p1 = p2
                p2 = p2.next
            p1.next = new_node
            new_node.next = p2
            
            odd = (self.n_elem % 2) != 0
            if num > self.mid.data:
                
                # insert at the right of self.mid
                if odd is False:
                    self.mid = self.mid.next
                    self.median = self.mid.data
                else:
                    self.median = (self.mid.data + self.mid.next.data)/2
                    
            else:
                # insert at the left of self.mid
                
                if odd:
                    # if odd, self.mid move left
                    p1 = new_node
                    p2 = p1.next
                    while p2 != self.mid:
                        p1 = p1.next
                        p2 = p2.next
                    self.mid = p1
                    
                    self.median = (self.mid.data + self.mid.next.data)/2
                else:
                    self.median = self.mid.data
                    
            self.n_elem += 1
        
        

    def findMedian(self) -> float:
        
        # odd = (self.n_elem % 2) != 0
        # if odd:
        #     return self.mid.data
        # else:
        #     return (self.mid.data + self.mid.next.data)/2
        
        return self.median

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        