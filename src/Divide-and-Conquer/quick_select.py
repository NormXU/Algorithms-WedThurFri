class Solution(object):
	def kthLargestElement(self, n, nums):
		if n < 0 or nums is None or len(nums) == 0:
			return -1

		start = 0
		end = len(nums)
		self.quickSelect(nums, start,end,len(nums)-n):

	def quickSelect(self, nums, start, end, n):
		if start == end:
			return nums[n]

		mid = (start + end) //2
		pivot = nums[mid]
		leftIdx = start
		rightIdx = end

		while leftIdx <= rightIdx:
			while leftIdx <= rightIdx and nums[leftIdx] < pivot:
				leftIdx += 1

			while  leftIdx <= rightIdx and nums[rightIdx] > pivot:
				rightIdx -= 1

			if leftIdx <= rightIdx:
				nums[leftIdx], nums[rightIdx] = nums[rightIdx], nums[leftIdx]
				leftIdx += 1
				rightIdx -= 1


		if n <= rightIdx:
			return self.quickSelect(nums,start,rightIdx,n):

		if n >= leftIdx:
			return self.quickSelect(nums, leftIdx, end, n)

		return nums[n]

	
		