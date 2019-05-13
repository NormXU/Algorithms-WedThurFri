"""
	Given an array of integers, find how many pairs in the array such that their sum is less than or equal to a specific target number. 
	Please return the number of pairs.

	Example
		Given nums = [2, 7, 11, 15], target = 24.
		Return 5.
		2 + 7 < 24
		2 + 11 < 24
		2 + 15 < 24
		7 + 11 < 24
		7 + 15 < 25
"""
class Solution1:
    """
    @param nums: an array of integer
    @param target: an integer
    @return: an integer
    """
    def twoSum5(self, nums, target):
        # write your code here
        nums.sort()
        count = 0
        end = len(nums)-1
        while end > 0:
            start = end - 1
            while nums[start] + nums[end] > target and start >=0 and end > 0:
                start -= 1
            count = count + start + 1
            end -= 1
        
        return count


class Solution2:
    """
    @param nums: an array of integer
    @param target: an integer
    @return: an integer
    """
    def twoSum5(self, nums, target):
        # write your code here
        nums.sort()
        count = 0
        start, end = 0, len(nums)-1
        while start < end:
            while nums[start] + nums[end] > target and start < end:
                end -= 1
            if nums[start] + nums[end] <= target and start < end:
                count = count + end - start
                start += 1
        
        return count
