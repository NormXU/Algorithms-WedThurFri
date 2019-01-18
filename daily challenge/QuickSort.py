class Solution(object):
	"""docstring for Solution"""
	def quickSort(self, A, start, end):
		if start >= end:
			return
		left, right = start, end
		mid = (left + right) // 2

		pivot = A[mid]

		while left <= right:
			while left <= right and A[left] < pivot:
				left += 1

			while left <= right and A[right] > pivot:
				right -= 1

			if left <= right:
				A[left], A[right] = A[right], A[left]
				left += 1
				right -= 1


		self.quickSort(A,start,right)
		self.quickSort(A,left,end)
		