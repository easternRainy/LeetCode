# Dict of Dict version: Out of time limit
class TimeMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.table = dict()
        
        

    def set(self, key: str, value: str, timestamp: int) -> None:
        if self.table.get(key) is None:
            self.table[key] = dict()
            self.table[key][timestamp] = value
            
        else:
            ts_dict = self.table[key]
            ts_dict[timestamp] = value
            
        
        

    def get(self, key: str, timestamp: int) -> str:
        if self.table.get(key) is None:
            return None
        
        ts_dict = self.table.get(key)
        
        ts = [t for t in list(ts_dict.keys()) if t <= timestamp]
        
        if len(ts) == 0:
            return ""
        else:
            return ts_dict[ts[-1]]
       

# Binary Search Version: out of time limit
class TimeMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.table = dict()        

    def set(self, key: str, value: str, timestamp: int) -> None:
        if self.table.get(key) is None:
            self.table[key] = dict()
            self.table[key][timestamp] = value
            
        else:
            ts_dict = self.table[key]
            ts_dict[timestamp] = value
            
        
    def get(self, key: str, timestamp: int) -> str:
        if self.table.get(key) is None:
            return None
        
        ts_dict = self.table.get(key)
        ts_list = list(ts_dict.keys())
        
        if ts_dict.get(timestamp) is not None:
            return ts_dict.get(timestamp)
        
        if timestamp < ts_list[0]:
            return ""
        
        if timestamp > ts_list[-1]:
            return ts_dict[ts_list[-1]]
        
        ts = search_max_ts(ts_list, timestamp)
        
        
        if ts is None:
            return ""
        else:
            return ts_dict[ts]
       
    
def search_max_ts(ts_list, ts):
    """return the max timestamp in ts_list that is less than to ts"""
    """assume ts_list is sorted ascendingly and ts is not in ts_list"""
    left = 0
    right = len(ts_list) - 1
    

       
    while (right - left) > 1:
        mid = (left + right) // 2
        
        mid_val = ts_list[mid]
        
        if mid_val < ts:
            left = mid
        else:
            right = mid
            
    return ts_list[left]


# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)


# defaultdict and SortedDict with Binary Search: Passed

from sortedcontainers import SortedDict

class TimeMap:
   
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.table = defaultdict(SortedDict)        

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.table[key][timestamp] = value
            
        
    def get(self, key: str, timestamp: int) -> str:
        if key not in self.table.keys(): return ""
        
        ts_keys = self.table[key].keys()
        
        if timestamp < ts_keys[0]: return ""
        
        if timestamp > ts_keys[-1]: return self.table[key][ts_keys[-1]]
        
        if timestamp in ts_keys: return self.table[key][timestamp]
        
        left = 0
        right = len(ts_keys) - 1
        
        # Now we assure that timestamp is not in the list
        # So we want to find a range (left, right), such that
        # right = left + 1 and left < timestampe < right
        while (right - left) > 1:
            mid = (left + right) // 2
            if mid < timestamp:
                left = mid
            else:
                right = mid
                
        return self.table[key][ts_keys[left]]
        
        



# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)
        