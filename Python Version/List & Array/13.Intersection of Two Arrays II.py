Given two arrays, write a function to compute their intersection.

Example
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

这一次可以存在重复的元素。

类似于merge two sorted array.

class Solution:
    """
    @param nums1: an integer array
    @param nums2: an integer array
    @return: an integer array
    """
    def intersection(self, nums1, nums2):
        # write your code here
        nums1.sort()
        nums2.sort()
        p1, p2 = 0, 0
        result = []

        while p1 < len(nums1) and p2 < len(nums2):
            if nums1[p1] < nums2[p2]:
                p1 += 1
            elif nums1[p1] > nums2[p2]:
                p2 += 1
            elif nums1[p1] == nums2[p2]:
                result.append(nums1[p1])
                p1 += 1
                p2 += 1

        return result
