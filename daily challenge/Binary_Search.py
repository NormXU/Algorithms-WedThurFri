class Solution(object):
	def binarySearch(self, A, target):
		start, end = 0, len(A) - 1
		while start+1 < end:
			mid = (start + end) // 2
			if A[mid] == target:
				return mid
			if A[mid] < target:
				start = mid + 1
			if A[mid] > target:
				end = mid - 1

		if A[start] == target:
			return start
		if A[end] == target:
			return end

		return -1