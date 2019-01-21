"""
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Example
Input: [1,2,2]
Output:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
"""
class Solution:
    """
    @param nums: A set of numbers.
    @return: A list of lists. All valid subsets.
    """
    def subsetsWithDup(self, nums):
        # write your code here
        nums.sort()
        self.result = []
        self.dfs(nums, [], 0)
        return self.result
    
    def dfs(self, nums, result, idx):
        self.result.append(result)
        
        for i in range(idx, len(nums)):
            if i > 0 and nums[i-1] == nums[i] and i != idx:
                continue
            self.dfs(nums, result + [nums[i]], i+1)