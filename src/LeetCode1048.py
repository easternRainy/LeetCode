class Node:
    def __init__(self, s):
        self.s = s
        self.children = []
        
    def debug(self):
        print(self.s)
        for n in self.children:
            n.debug()
    
class NodeTree:
    def __init__(self):
        self.root = Node("")
        
    def add(self, s):
        if len(self.root.children) == 0:
            self.root.children.append(Node(s))
            return
        
        result = False
        for n in self.root.children:
            add_branch = self._add(n, s)
            if add_branch is True:
                result = True
                break
                
        if result is False:
            self.root.children.append(Node(s))
    
    def _add(self, node, s):
        # assume len(node.s) > 0
        
        if is_pre(node.s, s):
            
            # print(f"{node.s} and {s}")
            new_node = Node(s)
            node.children.append(new_node)
            
            return True
        
        for n in node.children:
            add_branch = self._add(n, s)
            if add_branch is True:
                return True
            
        return False
            
    
    def get_height(self):
        return self._get_height(self.root)
    
    def _get_height(self, node):
        if len(node.children) == 0:
            return 0
        
        height = 1
        hs = []
        for n in node.children:
            h = self._get_height(n)
            # print(f"{h}, {n.s}")
            hs.append(h)
            
        if len(hs) > 0:
            height += max(hs)
            
        return height
    
    def debug(self):
        self.root.debug()
    
class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        words = sorted(words, key=len)
        
        # print(words)
        tree = NodeTree()
        for word in words:
            tree.add(word)
            # tree.debug()
            # print("----")
            
        return tree.get_height()
        
        
def is_pre(word1, word2):
    """return if word1 is predecessor of word2"""
    if len(word2) <= len(word1):
        return False
    
    c_list = list(word2)
    for i in range(len(c_list)):
        tmp = c_list.copy()
        del tmp[i]
        if "".join(tmp) == word1:
            return True
    return False