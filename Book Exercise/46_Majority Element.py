"""
Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.

Example
Example 1:

Input: [1, 1, 1, 1, 2, 2, 2]
Output: 1
Example 2:

Input: [1, 1, 1, 2, 2, 2, 2]
Output: 2
"""
class Solution:
    """
    @param: nums: a list of integers
    @return: find a  majority number
    """
    def majorityNumber(self, nums):
        key, count = None, 0
        for num in nums:
            if key is None:
                key, count = num, 1
            else:
                if key == num:
                    count += 1
                else:
                    count -= 1

            if count == 0:
                key = None

        return key
