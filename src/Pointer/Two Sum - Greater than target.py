"""
	Given an array of integers, find how many pairs in the array such that their sum is bigger than a specific target number. Please return the number of pairs.

	Example
		Given numbers = [2, 7, 11, 15], target = 24. Return 1. (11 + 15 is the only pair)

	Challenge
		Do it in O(1) extra space and O(nlogn) time.
"""
class Solution:
    """
    @param nums: an array of integer
    @param target: An integer
    @return: an integer
    """
    def twoSum2(self, nums, target):
    	nums.sort()
    	cnt = 0
    	start, end = 0, len(nums) - 1
    	while start < end:
    		if nums[start] + nums[end] <= target and start < end:
    			start += 1
    		else:
    			cnt = cnt + end - start
    			end -= 1

    	return cnt