"""
Given 2*n + 1 numbers, every numbers occurs twice except one, find it.

Example
Given [1,2,2,1,3,4,3], return 4
"""
class Solution:
    """
    @param A: An integer array
    @return: An integer
    """
    def singleNumber(self, A):

        dic = {key:0 for key in A}
        for num in A:
            dic[num] += 1

        for key,cnt in dic.items():
            if cnt != 2:
                return key
        
