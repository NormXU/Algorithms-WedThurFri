"""
	Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

	Example
	Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

	Notice
	You must do this in-place without making a copy of the array.
	Minimize the total number of operations.
"""
class Solution:
    """
    @param nums: an integer array
    @return: nothing
    """
    def moveZeroes(self, nums):
        # write your code here
        slow = 0
        fast = 1
        if len(nums)==2:
            if nums[fast] < nums[slow]:
                nums[slow], nums[fast] = nums[fast], nums[slow]
                return nums
            else:
                return nums

        while fast < len(nums) - 1:
        	while nums[fast] == 0 and fast < len(nums) - 1:
        		fast += 1
        	while nums[slow] != 0 and slow < len(nums) - 1:
        		slow += 1

        	if slow < fast:
        		nums[slow], nums[fast] = nums[fast], nums[slow]
        	else:
        		fast += 1

        return nums