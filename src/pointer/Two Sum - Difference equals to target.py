"""
Given an array of integers, find two numbers that their difference equals to a target value.
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are NOT zero-based.

Example
Given nums = [2, 7, 15, 24], target = 5
return [1, 2] (7 - 2 = 5)

"""
class Solution:
    """
    @param nums: an array of Integer
    @param target: an integer
    @return: [index1 + 1, index2 + 1] (index1 < index2)
    """
    def twoSum7(self, nums, target):
    	if nums is None or len(nums) == 0:
    		return -1

    	if target is None:
    		return []
    		
    	#注意：：由于每次排序后，原list各个元素对应的index的值就丢失了。这是很不方便的。为了解决这一世纪难题
    	nums = [(num,i) for i, num in enumerate(nums)]
    	nums = sorted(nums, key = lambda x: x[0]) #按照x[0]对整个list进行排序
    	left = 0
    	right = 1
    	for left in range(len(nums) - 1):
    		while right < len(nums) and nums[right][0] - nums[left][0] < abs(target):
    			right += 1

    		if nums[right][0] - nums[left][0] == abs(target) and left != right:
    			return sorted([nums[left][1],nums[right][1]])

    		if nums[right][0] - nums[left][0] == abs(target) and left == right:
    			if nums[right+1][0] - nums[left][0] == abs(target):
    			return [nums[left][1],nums[right+1][1]]

    		left += 1