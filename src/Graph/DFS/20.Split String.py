"""
Give a string, you can choose to split the string after one character or two adjacent characters, and make the string to be composed of only one character or two characters. Output all possible results.

Example
Given the string "123"
return [["1","2","3"],["12","3"],["1","23"]]

"""

class Solution:
    """
    @param: : a string to be split
    @return: all possible split string array
    """

    def splitString(self, s):
        # write your code here
        if len(s) == 0:
            return [[]]

        result = []
        subset = []
        index = 0
        self.dfs(s, subset, index, result)
        return result

    def dfs(self, s, subset, index, result):
        if index == len(s):
            return result.append(list(subset))

        for i in range(index, min(len(s), index + 1) ):
            subset.append(s[index:i+1])
            self.dfs(s, subset, index + 1, result)
            subset.pop()
