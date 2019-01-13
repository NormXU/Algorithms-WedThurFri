class Solution(object):
	def sortIntegers(self, A):
		# 开辟一片空间，其长度与A的长度一样，且全部都初始化为0
		tmp = [0 for _ in range(len(A))]
		start = 0
		end = len(A)-1
		self.merge_sort(A, start, end, tmp)


	def merge_sort(self, A, start, end, temp):
		# Special Cases 
		if start >= end:
			return
		mid = (start+end)//2
		self.merge_sort(A, start, mid, temp)
		self.merge_sort(A, mid+1, end, temp)
		self.merge(start, mid, end, A, temp)

	def  merge(self, start, mid, end, A, temp):
		leftIdx = start
		rightIdx = mid + 1
		index = start
		if leftIdx <= mid and rightIdx <= end:
			if A[leftIdx] < A[rightIdx]:
				temp[index] = A[leftIdx]
				leftIdx += 1
			else:
				temp[index] = A[rightIdx]
				rightIdx += 1

			index += 1


		# 当左半部分或者有半部分有一个取完了，而另一部分还没取完的时候，接下来的代码的目的是取完剩下的部分
		while leftIdx <= mid:
			temp[index] = A[leftIdx]
			leftIdx += 1
			index += 1

		while rightIdx <= end:
			temp[index] = A[rightIdx]
			rightIdx += 1
			index += 1

		A = temp.copy()
