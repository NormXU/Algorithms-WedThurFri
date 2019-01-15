def template(self, nums, target):
	nums.sort()
	start, end = 0, len(nums) - 1
	while start < end:
		if nums[start]+nums[end] == target:
			start += 1
			end -= 1
			while start < end and nums[start] == nums[start-1]:
				start += 1
			while start < end and nums[end] == nums[end + 1]:
				end -= 1
		if nums[start] + nums[end] > target:
			end -= 1
		if nums[start] + nums[end] < target:
			start += 1
