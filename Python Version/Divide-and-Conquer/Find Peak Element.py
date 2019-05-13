"""
There is an integer array which has the following features:

The numbers in adjacent positions are different.
A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
We define a position P is a peak if:

A[P] > A[P-1] && A[P] > A[P+1]
Find a peak element in this array. Return the index of the peak.
"""
class Solution:
    """
    @param A: An integers array.
    @return: return any of peek positions.
    """
    def findPeak(self, A):
        # write your code here
        if A is None or len(A) == 0:
        	return -1
        start, end = 0, len(A) - 1
        while start + 1 < end:
        	mid = (start + end) // 2
        	if A[mid] > A[mid + 1]:
        		end = mid
        	else:
        		start = mid

        return end