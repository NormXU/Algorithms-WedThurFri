"""
Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.

Example
Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
"""
class Solution:
    """
    @param: nums: A list of integers
    @return: A list of integers includes the index of the first number and the index of the last number
    """
    def subarraySumClosest(self, nums):
        # write your code here
        prefix_sum = [(0, -1)]
        for i, num in enumerate(nums):
            prefix_sum.append( (prefix_sum[-1][0] +num, i))

        prefix_sum.sort()

        closet, answer = sys.maxsize, []
        for i in range(1, len(prefix_sum)):
            if closet > prefix_sum[i][0] - prefix_sum[i-1][0]:
                closet = prefix_sum[i][0] - prefix_sum[i-1][0]
                left = min(prefix_sum[i-1][1], prefix_sum[i][1]) + 1
                right = max(prefix_sum[i-1][1], prefix_sum[i][1])
                answer = [left, right]

        return answer
                
