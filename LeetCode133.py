"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

"""
Q2. Deep copy a graph
  6 - 1
  | / \
   2   3
  / \
 4   5
"""
"""
{1: node(1), 2: node(2), 3:node(3), 4: node(4), 5: node(5), 6: node(6)}

{1: cpnode(1), 2: cpnode(2), 3:cpnode(3), 4: cpnode(4), 5: cpnode(5), 6: cpnode(6)}
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return node
        
        all_nodes = dict()
        self.dfs(node, all_nodes)
        
        all_nodes_cp = dict()
        for k in all_nodes.keys():
            all_nodes_cp[k] = Node(k)
            
        for k in all_nodes.keys():
            origin_node = all_nodes[k]
            copy_node = all_nodes_cp[k]
            for n in origin_node.neighbors:
                copy_node.neighbors.append(all_nodes_cp[n.val])
          
        return all_nodes_cp[node.val]
    
        
        
    def dfs(self, node, all_nodes):
        """return an dict for all nodes"""
        if not node:
            return node
        
        if node in all_nodes.values():
            return
        
        all_nodes[node.val] = node
            
        for n in node.neighbors:
            self.dfs(n, all_nodes)