"""
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example
Given n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4]
]

"""


class Solution:
    """
    @param n: Given the range of numbers
    @param k: Given the numbers of combinations
    @return: All the combinations of k numbers out of 1..n
    """
    def combine(self, n, k):
        result = []
        subset = []
        index = 1
        self.dfs(n, k, index, subset, result)

    def dfs(self, n, k, index, subset, result):
        if k == 0:
            return result.append(list(subset))

        for i in range(index, n+1):
            subset.append(i)
            self.dfs(n, k-1, index+1,subset, result)
            subset.pop()
