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
    	#循环的出口
    	if index == len(nums):
    		self.result.append(seq)
    		return

    	x = nums[index]
    	# 该数不存在
    	self.dfs(nums, seq, index+1)
    	# 该数存在
    	self.dfs(nums, seq+[x],index+1)





class Solution2:
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
            self.dfs(nums, result + [nums[i]], i+1)