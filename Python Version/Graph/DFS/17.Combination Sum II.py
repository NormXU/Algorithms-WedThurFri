"""
Example
Given candidate set [10,1,6,7,2,1,5] and target 8,

A solution set is:

[
  [1,7],
  [1,2,5],
  [2,6],
  [1,1,6]
]
"""
class Solution:
    """
    @param num: Given the candidate numbers
    @param target: Given the target number
    @return: All the combinations that sum to target
    """
    def combinationSum2(self, num, target):
        # write your code here
        num = sorted(num)
        index = 0
        result = []
        subset = []
        self.dfs(num, target, index, result, subset)
        return result


    def dfs(self, num, target, index, result, subset):
        if target == 0:
            return result.append(list(subset))

        for i in range(index, len(num)):
            if num[i] > target:
                return
            if i != 0 and num[i] == num[i-1] and i > index:
                continue
            subset.append(num[i])
            self.dfs(num,target - num[i], i+1, result, subset)
            subset.pop()
