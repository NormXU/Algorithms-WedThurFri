def template(self, nums, target):
	num.sort() # ascending
	start, end = 0, len(nums)-1
	while start + 1 < end:
		mid = ( start + end )
		if nums[mid] == target:
			return mid
		if nums[mid] > target:
			end = mid - 1
		if nums[mid] < target:
			start = mid + 1

	# 当退出后，start + 1 == end， 整个数列只存留两个元素，因此要对每一个元素进行检查		

	if nums[start] == target:
		return start

	if nums[end] == target:
		return end

	return -1