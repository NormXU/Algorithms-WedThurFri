"""
Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.

Return the difference between the sum of the two integers and the target.

Example
Given array nums = [-1, 2, 1, -4], and target = 4.

The minimum difference is 1. (4 - (2 + 1) = 1).
"""
class Solution(object):
	 """
    @param nums: an integer array
    @param target: An integer
    @return: the difference between the sum and the target
    """
    def twoSumClosest(self, nums, target):
    	nums.sort()
    	start, end = 0, len(nums)-1
    	diff = abs(target - nums[start] - nums[end])

    	while start+1 < end:
    		if nums[start] + nums[end] < target:
    			start += 1
    			diff = min(diff, abs(target - nums[start] - nums[end]))

    		if nums[start] + nums[end] > target:
                end -= 1
                diff = min(diff, abs(target - nums[start] - nums[end]))
                
                
            if nums[start] + nums[end] == target:
                return 0
                
        return diff
