"""
Example
Given s = "aab", return:

[
  ["aa","b"],
  ["a","a","b"]
]
"""
class Solution:
    """
    @param: s: A string
    @return: A list of lists of string
    """
    def partition(self, s):
        # write your code here
        result = []
        if s is None or len(s) == 0:
            return []
        subset = []
        index = 0
        self.dfs(result, subset, index, s)
        return result

    def dfs(self, result, subset, index, s):
        if index == len(s):
            result.append(subset[:])
            return
        for i in range(index, len(s)):
            substr = s[index:i+1]
            if not self.isPalindrome(substr):
                continue
            subset.append(substr)
            self.dfs(result, subset, i+1, s)
            subset.pop()

    def isPalindrome(self, s):
        start, end = 0, len(s)-1
        while start < end:
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1

        return True
