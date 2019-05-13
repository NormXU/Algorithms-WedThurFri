"""
Reverse digits of an integer. Returns 0 when the reversed integer overflows (signed 32-bit integer).

Example
Given x = 123, return 321

Given x = -123, return -321
"""
class Solution:
    """
    @param n: the integer to be reversed
    @return: the reversed integer
    """
    def reverseInteger(self, n):
        # write your code here
        if abs(n) < 10:
            return n

        r = int(str(abs(n))[::-1])

        if r >= pow(2,31):
            return 0
        return r if n > 0 else -r
