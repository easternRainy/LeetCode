from collections import defaultdict, OrderedDict
from sortedcontainers import SortedList, SortedDict


class Solution:
    def highFive(self, items: List[List[int]]) -> List[List[int]]:
        table = defaultdict(SortedList)
        for (k, v) in items:
            table[k].add(v)
            
        result = []
        for k in sorted(list(table.keys())):
            grades = table[k][-5:]
            avg = int(sum(grades) / 5)
            result.append([k, avg])
            
        return result