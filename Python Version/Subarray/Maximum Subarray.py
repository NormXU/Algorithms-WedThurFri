"""
Given an array of integers, find a contiguous subarray which has the largest sum.

Example
Example1:
Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
Example2:
Given the array [1,2,3,4], the contiguous subarray [1,2,3,4] has the largest sum = 10.

"""
class Solution:
    """
    @param nums: A list of integers
    @return: A integer indicate the sum of max subarray
    """
    def maxSubArray(self, nums):
        # write your code here
        max_sum, min_sum = -sys.maxzie, 0
        prefix_sum = 0
        for num in nums:
            prefix_sum += num
            max_sum = max(max_sum, prefix_sum - min_sum)
            min_sum = min(min_sum, prefix_sum)

        return max_sum
