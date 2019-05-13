"""
	Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

	Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

	Example
	Given [1, 0, 1, 2], sort it in-place to [0, 1, 1, 2].
"""

class Solution:
    """
    @param nums: A list of integer which is 0, 1 or 2 
    @return: nothing
    """
    def sortColors(self, nums):
        # write your code here
        if nums is None:
            return -1
        start, end = 0, len(nums) - 1
        self.quickSort(nums, start, end)
    
    def quickSort(self, nums, start, end):
        if start >= end:
            return
        left, right = start, end
        pivot = nums[(start + end) // 2]
        while left <= right:
            while left <= right and nums[left] < pivot:
                left += 1
            
            while left <= right and nums[right] > pivot:
                right -= 1
            
            if left <= right:
                nums[left],nums[right] = nums[right],nums[left]
                left += 1
                right -= 1
        
        self.quickSort(nums,start, right)
        self.quickSort(nums,left,end)