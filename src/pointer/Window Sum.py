"""
Given an array of n integers, and a moving window(size k), move the window at each iteration from the start of the array, find the sum of the element inside the window at each moving.

Example
For array [1,2,7,8,5], moving window size k = 3.
1 + 2 + 7 = 10
2 + 7 + 8 = 17
7 + 8 + 5 = 20
return [10,17,20]
"""

class Solution:
    """
    @param nums: a list of integers.
    @param k: length of window.
    @return: the sum of the element inside the window at each moving.
    """
    def winSum(self, nums, k):
        # write your code here
        if nums is None or len(nums) == 0 or k == 0:
            return []
        if k == 1:
            return nums
            
        left = 0
        right = 1
        answer = []
        sum_tmp = nums[left]
        
        while right < k:
            sum_tmp = sum_tmp + nums[right]
            right += 1
        answer.append(sum_tmp)
                
        while left < len(nums)-k and right <= len(nums):
            sum_tmp = sum_tmp - nums[left]
            left += 1
            sum_tmp = sum_tmp + nums[right]
            answer.append(sum_tmp)
            right += 1
        
        return answer

    		