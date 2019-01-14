"""
Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.

Example
Given nums = [1, 2, 4, 8, 6, 3] return 8
Given nums = [10, 9, 8, 7], return 10

"""
class Solution:
    """
    @param nums: a mountain sequence which increase firstly and then decrease
    @return: then mountain top
    """
    # 依然是套用模板，但判定条件变化为，nums[i] > nums[i+1]
    def mountainSequence(self, nums):
    	if nums is None or len(nums) == 0:
    		return -1
    	start, end = 0, len(nums)-1
    	while start + 1 < end:
    		mid = (start + end) // 2
    		if nums[mid] > nums[mid+1]:
    			end = mid
    		else:
    			start = mid

    	return max(nums[start],nums[end])
