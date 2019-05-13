"""
Given an array of integers, remove the duplicate numbers in it.

You should:

Do it in place in the array.
Move the unique numbers to the front of the array.
Return the total number of the unique numbers.
Example
Given nums = [1,3,1,4,4,2], you should:

Move duplicate integers to the tail of nums => nums = [1,3,4,2,?,?].
Return the number of unique integers in nums => 4.
Actually we don't care about what you place in ?, we only care about the part which has no duplicate integers.

"""
class Solution(object):
	"""
    @param nums: an array of integers
    @return: the number of unique integers
    """
    def deduplication(self, nums):
    	if nums is None or len(nums) == 0:
    		return 0
    	right = 1
    	left = 0
    	while right < len(nums):
    		if nums[left] != nums[right]:
    			left += 1
    			nums[left] == nums[right]
    		right += 1

    	return left + 1