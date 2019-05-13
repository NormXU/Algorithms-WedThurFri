"""
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

Example
Given nums = [2, 7, 11, 15], target = 9
return [1, 2]
"""
class Solution1(object):
	"""
    @param nums: an array of Integer
    @param target: target = nums[index1] + nums[index2]
    @return: [index1 + 1, index2 + 1] (index1 < index2)
    """

    def two_sum(self, nums, target):
    	if not nums:
    		return False
    	for i in range(len(nums)-1):
    		for j in range(i+1,len(nums)):
    			if nums[i]+nums[j] == target:
    				return [i+1. j+1]
    			else:
    				if i == len(nums) - 1 and j == len(nums):
    					return False
		