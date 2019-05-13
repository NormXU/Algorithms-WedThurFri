"""
Count how many 1 in binary representation of a 32-bit integer.

Example
Example 1:

Input: 32
Output: 1
Explanation:
32(100000), return 1.
Example 2:

Input: 5
Output: 2
Explanation:
5(101), return 2.
"""
class Solution:
    """
    @param: num: An integer
    @return: An integer
    """
    def countOnes(self, num):
        # write your code here
        mask = 2**32 - 1
        if num < 0:
            num = num & mask
        cnt = 0
        while num:
            cnt += 1
            num &= (num-1)

        return cnt
