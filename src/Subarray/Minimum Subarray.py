"""

Given an array of integers, find the subarray with smallest sum.

Return the sum of the subarray.

Example
For [1, -1, -2, 1], return -3.

"""
class Solution:
    """
    @param: nums: a list of integers
    @return: A integer indicate the sum of minimum subarray
    """
    def minSubArray(self, nums):
        nums = [-1 * x for x in nums]
        prefix_sum = 0
        min_sum, max_sum = 0, -sys.maxsize

        for num in nums:
            prefix_sum += num
            max_sum = max(max_sum, prefix_sum - min_sum)
            min_sum = min(min_sum, prefix_sum)

        return -max_sum
