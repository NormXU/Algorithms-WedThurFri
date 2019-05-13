"""
The code base version is an integer start from 1 to n. One day, someone committed a bad version in the code case, so it caused this version and the following versions are all failed in the unit tests. Find the first bad version.

You can call isBadVersion to help you determine which version is the first bad one. The details interface can be found in the code's annotation part.

Example
Given n = 5:

isBadVersion(3) -> false
isBadVersion(5) -> true
isBadVersion(4) -> true
Here we are 100% sure that the 4th version is the first bad version
You can use SVNRepo.isBadVersion(10) to check whether version 10 is a 
bad version.
"""
"""
这是一道二分法的变形题，由于版本号是不断增加的，实际上是一个Sorted Array oooooxxxxxx
也就是找第一个X是在哪里。二分法模板需要使用熟练
"""
class Solution:
    """
    @param n: An integer
    @return: An integer which is the first bad version.
    """
    def findFirstBadVersion(self, n):
    	if n is None or n < 0:
    		return -1
    	start ,end = 0, n
    	while start+1 < end:
    		mid = (start + end) // 2
    		if SVNRepo.isBadVersion(mid):
    			# 是BadVerson，但不一定是最小的那个BadVersion
    			end = mid
    		else:
    			start = mid

    	if SVNRepo.isBadVersion(start):
    		return start
    	return end