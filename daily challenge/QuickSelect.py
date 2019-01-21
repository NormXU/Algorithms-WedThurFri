class Solution:
    """
    @param k: An integer
    @param nums: An integer array
    @return: kth smallest element
    """
    def kthSmallest(self, k, nums):
        # write your code here
        
        return self.quick_select(k, nums, 0, len(nums) - 1)

    def quick_select(self, k, nums, start, end):

    	if start >= end:
    		return
    	left = start
    	right = end
    	pivot = nums[(left+right)//2]

    	while left <= right:
    		while left <= right and nums[left] < pivot:
    			left += 1
    		while left <= right and nums[right] > pivot:
    			right -= 1
    		if left <= right:
    			right -= 1
    			left += 1

    	if start + k - 1 <= right:
    		return self.quick_select(k, nums,start,right)

    	if start + k - 1 >= left:
    		return self.quick_select(k - left + start, nums, left, end)

    	return nums[right + 1]