"""
Partition an integers array into odd number first and even number second.

Example
Given [1, 2, 3, 4], return [1, 3, 2, 4]
"""


# 模仿 QuickSort

class Solution:
    """
    @param: nums: an array of integers
    @return: nothing
    """
    def partitionArray(self, nums):
        # write your code here
        if nums is None or len(nums) == 0:
            return []
        if len(nums) <= 2:
            return nums
        start, end = 0, len(nums)-1
        while start <= end:
            while start <= end and nums[start] %2 == 1:
                start += 1
            while start <= end and nums[end] %2 == 0:
                end -= 1
            if start <= end:
                nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1

        return nums
