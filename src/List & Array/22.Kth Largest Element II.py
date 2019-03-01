"""
Find K-th largest element in an array. and N is much larger than k.

Example
Example 1:

Input:[9,3,2,4,8],3
Output:4

Example 2:

Input:[1,2,3,4,5,6,8,9,10,7],10
Output:1
"""
class Solution:
    """
    @param nums: an integer unsorted array
    @param k: an integer from 1 to n
    @return: the kth largest element
    """
    def kthLargestElement2(self, nums, k):
        import heapq
        heap = []
        for num in nums:
            heapq.heappush(heap, num)
            if len(heap) > k:
                heapq.heappop(heap)

        return heapq.heappop(heap)
