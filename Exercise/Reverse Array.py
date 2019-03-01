"""
Reverse the given array nums inplace.

Example
Given nums = [1,2,5]
return [5,2,1]
"""
class Solution:
    """
    @param nums: a integer array
    @return: nothing
    """
    def reverseArray(self, nums):
        i, j = 0, len(nums) - 1
        while i <= j:
            nums[i], nums[j] = nums[j], nums[i]
            i++
            j--
