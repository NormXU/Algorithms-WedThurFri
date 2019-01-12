class Solution:
    """
    @param A: an integer array
    @return: nothing
    """
    def sortIntegers(self, A):
    	if A is None or len(A) == 0:
    		return False

    	start, end = 0, len(A)-1
    	self.quicksort(A,start,end)

    def quicksort(self,A,start,end):
    	left, right = start, end
    	pivot = A[(start + end)//2]
    	while left <= right:
    		while left <= right and A[left] < pivot:
    			left += 1
    		
    		while left <= right and A[right] > pivot:
    			right -= 1
    		
    		if left <= right:
    			A[left], A[right] = A[right], A[left]
    			right -= 1
    			left += 1

    	#每次完成这个循环后，left 就会大于right， 而pivot就会在自己本应该在的位置上
    	self.quicksort(A,start,right)
    	self.quicksort(A,left,end)