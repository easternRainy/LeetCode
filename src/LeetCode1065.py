class TrieNode:
    def __init__(self):
        self.is_word = False
        self.children = [None for _ in range(ord('a'), ord('z')+1)]
        
    def display(self):
        for i in range(0, ord('z')-ord('a')):
            if self.children[i] is not None:
                print(chr(ord('a')+i))
                print(self.children[i].is_word)
                self.children[i].display()
        
        
class TrieTree:
    def __init__(self):
        self.root = TrieNode()
        
    def insert(self, word):
        insert_word(self.root, word)
        
    def search(self, word):
        return search_word(self.root, word)

            
def insert_word(trie_node, word):
    if word is None:
        return

    if len(word) == 0:
        trie_node.is_word = True
        return

    idx = ord(word[0]) - ord('a')

    if trie_node.children[idx] is None:
        trie_node.children[idx] = TrieNode()
        
    insert_word(trie_node.children[idx], word[1:])

    
def search_word(trie_node, word):
    # print(word)
    if word is None or len(word) == 0:
        return False
    
    
    idx = ord(word[0]) - ord('a')
    
    if len(word) == 1:
        return trie_node.children[idx] is not None and trie_node.children[idx].is_word
    
    if trie_node.children[idx] is None:
        return False
    else:
        return search_word(trie_node.children[idx], word[1:])
        
        

class Solution:
    def indexPairs(self, text: str, words: List[str]) -> List[List[int]]:
        trie = TrieTree()
        results = []
        
        for word in words:
            trie.insert(word)
            
        for i in range(len(text)):
            idx = ord(text[i]) - ord('a')
            
            if trie.root.children[idx] is not None:
                j = i
                
                while(j < len(text)):
                    if trie.search(text[i:j+1]):
                        results.append([i, j])
                    j += 1
                    
        return results
                
                
                
                
                
                