"""
Given an integer array, heapify it into a min-heap array.

For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
Example
Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.
"""
class Solution:
    """
    @param: A: Given an integer array
    @return: nothing
    """
    def heapify(self, A):
        # write your code here
        for i in range(len(A)-1, -1, -1):
            self.siftdown(A, i)

    def siftdown(self, A, k):
        while k*2 + 1 < len(A):
            leftSon = k * 2 + 1 # leftSon index
            rightSon = k * 2 + 2
            if rightSon < len(A) and A[leftSon] > A[rightSon]:
                son = rightSon
            else:
                son = leftSon

            if A[son] >= A[k]:
                break
            A[son], A[k] = A[k], A[son]
            k = son

            
