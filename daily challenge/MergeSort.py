class Solution(object):
	def sorted(self, A):
		tmp = [0 for _ in range(len(A))]
		start, end = 0, len(A) - 1
		self.mergesort(A, start, end)

	def mergesort(self, A, start, end):
		if start >= end:
			return
		mid = (start + end) // 2
		self.mergesort(A,start,mid,tmp)
		self.mergesort(A,mid+1,start,tmp)
		self.merge(start,mid,end,A,tmp)

	def merge(self,start,mid,end,A,tmp):
		leftIdx = start
		rightIdx = mid + 1
		index = start
		if leftIdx <= mid and rightIdx <= end:
			if A[leftIdx] < A[rightIdx]:
				tmp[index] = A[leftIdx]
				leftIdx += 1
			else:
				tmp[index] = A[rightIdx]
				rightIdx += 1

			index += 1

		while leftIdx <= mid:
			tmp[index] = A[leftIdx]
			leftIdx+= 1
			index += 1

		while rightIdx <= mid:
			tmp[index] = A[rightIdx]
			rightIdx += 1
			index += 1

		A = tmp.copy()


		