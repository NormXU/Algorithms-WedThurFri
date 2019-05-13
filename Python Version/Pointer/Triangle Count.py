"""
	Given an array of integers, how many three numbers can be found in the array, so that we can build an triangle whose three edges length is the three numbers that we find?

	Example
	Given array S = [3,4,6,7], return 3. They are:

	[3,4,6]
	[3,6,7]
	[4,6,7]
	Given array S = [4,4,4,4], return 4. They are:

	[4(1),4(2),4(3)]
	[4(1),4(2),4(4)]
	[4(1),4(3),4(4)]
	[4(2),4(3),4(4)]
"""
class Solution:
    """
    @param S: A list of integers
    @return: An integer
    """
    def triangleCount(self, S):
    	S.sort()
    	count = 0
    	for i in range(len(S)):
    		left = 0
    		right = i-1
    		while left < right:
    			if S[left] + S[right] > S[i]:
    				count = count + right - left  # 1 2 3 4, 当右侧指针为4的时候，一共有1,4 2,4, 3,4 三种方案。 left - right
    				right -= 1
    			else:
    				left += 1

    	return count