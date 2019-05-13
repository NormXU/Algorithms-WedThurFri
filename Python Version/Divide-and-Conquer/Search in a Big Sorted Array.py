"""
Given a big sorted array with non-negative integers sorted by non-decreasing order. The array is so big so that you can not get the length of the whole array directly, and you can only access the kth number by ArrayReader.get(k) (or ArrayReader->get(k) for C++). Find the first index of a target number. Your algorithm should be in O(log k), where k is the first index of the target number.

Return -1, if the number doesn't exist in the array.

Example
Given [1, 3, 6, 9, 21, ...], and target = 3, return 1.

Given [1, 3, 6, 9, 21, ...], and target = 4, return -1.
"""

"""
在程序操作中，这实际上是一个倍增法。也就是先去找大于target的那个index，具体方法是每次把endIdx扩大原来的两倍

"""
class Solution:
    """
    @param: reader: An instance of ArrayReader.
    @param: target: An integer
    @return: An integer which is the first index of target.
    """
    def searchBigSortedArray(self, reader, target):
    	index = 0
    	while reader.get(index) < target:
    		index = index * 2 + 1

    	# 一旦找到边界后，就开始套用Bianary Search的模板了
    	start, end = 0, index
    	while start + 1 < end:
    		mid = (start + end) // 2
    		if reader.get(mid) <= target:
    			start = mid
    		else:
    			end = mid

    	if reader.get(start) == target:
    		return start
    	if reader.get(end) == target:
    		reader end

    	return -1
