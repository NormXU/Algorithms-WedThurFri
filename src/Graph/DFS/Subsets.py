"""
	Given a set of distinct integers, return all possible subsets.

		Example
		If S = [1,2,3], a solution is:

		[
		  [3],
		  [1],
		  [2],
		  [1,2,3],
		  [1,3],
		  [2,3],
		  [1,2],
		  []
		]
"""
class Solution:
    """
    @param nums: A set of numbers
    @return: A list of lists
    """
    def subsets(self, nums):
        # write your code here
        self.result = []
        nums.sort()
        self.dfs(nums, [], 0)
        return self.result


    def dfs(self, nums, seq, index):
    	if index == len(nums):
    		self.result.append(seq)
    		return

    	x = nums[index]
    	self.dfs(nums, seq, index+1)
    	self.dfs(nums, seq+[x],index+1)
