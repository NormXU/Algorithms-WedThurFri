"""

Given a target number, a non-negative integer k and an integer array A sorted in ascending order, find the k closest numbers to target in A, sorted in ascending order by the difference between the number and target. Otherwise, sorted in ascending order by number if the difference is same.

Example
Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].

Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6]

"""
class Solution(object):
	"""
    @param A: an integer array
    @param target: An integer
    @param k: An integer
    @return: an integer array
    """
    def kClosestNumbers(self, A, target, k):
    	if A is None or len(A) == 0:
    		return -1
    	left = 0
    	right = len(A) - 1

    	while left + 1 < right:
    		mid = (left + right)//2
    		if A[mid] <= target:
    			left = mid
    		else:
    			right = mid

    	result = []

    	while len(result) < k:
    		if left < 0:
                result.append(A[right])
                right += 1
                continue
            
            if right > len(A) - 1:
                result.append(A[left])
                left -= 1
                continue

    		if abs(A[right] - target) < abs(A[left]-target):
    			result.append(A[right])
    			right += 1
    			continue
    		else:
    			result.append(A[left])
    			left -= 1
    			continue

    	return result
