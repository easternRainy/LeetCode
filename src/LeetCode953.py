class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        order_dict = dict()
        
        i = 0
        order_dict[""] = i
        
        i += 1
        for c in order:
            order_dict[c] = i
            i += 1
            
        for i in range(len(words)-1):
            if compare(words[i], words[i+1], order_dict) > 0:
                return False
        
        return True
        
def compare(word1, word2, order_dict):
    """
    compare two words by order

    return -1 if word1 < word2
    return 0 if word1 == word2
    return 1 if word1 > word

    """
    if word1 == "" and word2 == "":
        return 0

    if word1 == "" and len(word2) > 0:
        return -1

    if len(word1) > 0 and word2 == "":
        return 1

    if word1[0] == word2[0]:
        return compare(word1[1:], word2[1:], order_dict)
    else:
        c1 = order_dict[word1[0]]
        c2 = order_dict[word2[0]]

        if c1 > c2:
            return 1
        else:
            return 0




            
            