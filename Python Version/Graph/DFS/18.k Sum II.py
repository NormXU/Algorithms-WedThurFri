"""
Given n unique integers, number k (1<=k<=n) and target.

Find all possible k integers where their sum is target.

Example
Given [1,2,3,4], k = 2, target = 5. Return:

[
  [1,4],
  [2,3]
]
"""
class Solution:
    """
    @param: A: an integer array
    @param: k: a postive integer <= length(A)
    @param: targer: an integer
    @return: A list of lists of integer
    """
    def kSumII(self, A, k, target):
        A = sorted(A)
        result = []
        index = 0
        subset = []
        self. dfs(A, index, k, target, subset, result)
        return result

    def dfs(self, A, index, k, target, subset, result):
        if k == 0 and target == 0:
            return result.append(list(subset))

        for i in range(index, len(A)):
            if A[i] > target:
                return
            subset.append(A[i])
            self.dfs(A, i+1, k-1, target - A[i], subset, result)
            subset.pop()
            
