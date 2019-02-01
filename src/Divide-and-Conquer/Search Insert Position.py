"""
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume NO duplicates in the array.

Example
[1,3,5,6], 5 → 2

[1,3,5,6], 2 → 1

[1,3,5,6], 7 → 4

[1,3,5,6], 0 → 0
"""


class Solution:
    """
    @param A: an integer sorted array
    @param target: an integer to be inserted
    @return: An integer
    """
    def searchInsert(self, A, target):
        if A is None or len(A) == 0:
            return 0

        start, end = 0, len(A)-1
        while start + 1 < end:
            mid = (start + end) // 2
            if A[mid] < target:
                start = mid
            if A[mid] >= target:
                end = mid

        if A[start] >= target:
            return start
        if A[end] >= target:
            return end
        return len(A)
