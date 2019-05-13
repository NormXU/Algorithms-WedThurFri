"""
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Example
Given candidate set [2,3,6,7] and target 7, a solution set is:

[7]
[2, 2, 3]
"""
class Solution:
    """
    @param candidates: A list of integers
    @param target: An integer
    @return: A list of lists of integers
    """
    def combinationSum(self, candidates, target):
        # write your code here
        candidates = sorted(list(set(candidates)))
        index = 0
        results = []
        self.dfs(candidates, target, index, results, [])
        return results

    def dfs(self, candidates, target, index, results, combination):
        if target == 0 :

            return results.append(list(combination))

        for i in range(index, len(candidates)):
            if target < candidates[i]:
                return

            combination.append(candidates[i])
            self.dfs(candidates, target - candidates[i], i, results, combination)
            combination.pop()
