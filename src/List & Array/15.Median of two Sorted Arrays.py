"""
There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.

Example
Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.

Given A=[1,2,3] and B=[4,5], the median is 3.
"""
class Solution:
    """
    @param: A: An integer array
    @param: B: An integer array
    @return: a double whose format is *.5 or *.0
    """
    def findMedianSortedArrays(self, A, B):
        # write your code here
        i,j =0,0
        ans = []
        while i < len(A) and j < len(B):
            if A[i] < B[j]:
                ans.append(A[i])
                i += 1
            else:
                ans.append(B[j])
                j += 1

        while i < len(A):
            ans.append(A[i])
            i += 1

        while j < len(B):
            ans.append(B[j])
            j += 1

        L = len(ans)
        if L % 2 == 0:
            return (ans[L//2] + ans[L//2-1]) / 2
        else:
            return ans[L//2]
