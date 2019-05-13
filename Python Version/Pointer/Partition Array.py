"""
	Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

	All elements < k are moved to the left
	All elements >= k are moved to the right
	Return the partitioning index, i.e the first index i nums[i] >= k.

	Example
	If nums = [3,2,2,1] and k=2, a valid answer is 1.
"""
class Solution:
    """
    @param nums: The integer array you should partition
    @param k: An integer
    @return: The index after partition
    """
    #这道题目是QuickSort的变形题
    def partitionArray(self, nums, k):
    	start, end = 0, len(nums)-1
    	while start <= end:
    		while start <= end and nums[start] < k:
    			start += 1
    		while  start <= end and nums[start] >= k:
    			end -= 1
    		if start <= end:
    			nums[start],nums[end] = nums[end],nums[start]
    			end -= 1
    			start += 1

    	return start