"""
	Given an array of integers, find how many unique pairs in the array such that their sum is equal to a specific target number. Please return the number of pairs.


	Example

	Given nums = [1,1,2,45,46,46], target = 47
	return 2

	1 + 46 = 47
	2 + 45 = 47

"""
#这里有一个经典的template, while 套着 while

class Solution(object):
	"""
    @param nums: an array of integer
    @param target: An integer
    @return: An integer
    """
    def twoSum6(self, nums, target):
    	nums.sort()
    	count = 0
    	start, end = 0, len(nums) - 1
    	while start < end:
    		if nums[start] + nums[end] == target:
    			count += 1
    			start += 1
    			end -= 1
    			while start<end and nums[start] == nums[start-1]:
    				start += 1
    			while start<end and nums[end] == nums[end+1]:
    				end -= 1

    		if nums[start] + nums[end] > target:
    			end -= 1
    		
    		if nums[start] + nums[end] < target:
    			start += 1
    	return count