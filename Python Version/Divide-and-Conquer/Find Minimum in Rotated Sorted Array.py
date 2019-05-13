"""
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

Example
Given [4, 5, 6, 7, 0, 1, 2] return 0

"""
# 若使用二分法，每次得罪中心值都应该与整个数列的最后一个值进行比较，如果中心值大于数列最后一个值，则更新start指针，否则更新end指针
class Solution1:
    """
    @param nums: a rotated sorted array
    @return: the minimum number in the array
    """
    def findMin(self, nums):
    	if nums is None or len(nums) == 0:
    		return -1
    	start, end = 0, len(nums) - 1
    	while start+1 > end:
    		mid = (start + end) // 2
    		if nums[mid] > nums[end]:
    			start = mid
    		else:
    			end = mid

    	return min(nums[start], nums[end])