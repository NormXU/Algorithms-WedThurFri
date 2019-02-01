"""
Given a sorted array of n integers, find the starting and ending position of a given target value.

If the target is not found in the array, return [-1, -1].

Example
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
"""
#这道题其实就是找 first position of element and Last Position of Element
# 要注意特殊情况 [5, 5, 5, 5, ,5 ,5 ] 这种上下限
class Solution:
    """
    @param A: an integer sorted array
    @param target: an integer to be inserted
    @return: a list of length 2, [index1, index2]
    """
    def searchRange(self, A, target):
        # write your code here
        if A is None or len(A) == 0:
            return [-1,-1]


        start, end = 0, len(A)-1
        while start + 1 < end:
            mid = (start + end) // 2
            if A[mid] >= target:
                end = mid

            if A[mid] < target:
                start = mid

        if A[start] == target:
            leftBound = start
        elif A[end] == target:
            leftBound = end
        else:
            return [-1, -1]


        start, end = leftBound, len(A)-1
        while start + 1 < end:
            mid = (start + end) // 2
            if A[mid] > target:
                end = mid
            if A[mid] <= target:
                start = mid
        if A[end] == target:
            rightBound = end
        elif A[start] == target:
            rightBound = start
        return [leftBound, rightBound]
