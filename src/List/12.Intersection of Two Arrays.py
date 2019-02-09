Given two arrays, write a function to compute their intersection.

Example
Example 1:

Input: nums1 = [1, 2, 2, 1], nums2 = [2, 2],
Output: [2].
Example 2:

Input: nums1 = [1, 2], nums2 = [2],
Output: [2].



class Solution1:
    """
    @param nums1: an integer array
    @param nums2: an integer array
    @return: an integer array
    """
    def intersection(self, nums1, nums2):
        return list(set(nums1) & set(nums2))


class Solution2:
    """
    @param nums1: an integer array
    @param nums2: an integer array
    @return: an integer array
    """
    def intersection(self, nums1, nums2):
        result = set()
        if len(nums1) > len(nums2):
            short_num = nums2
            long_num = nums1
        else:
            short_num = nums1
            long_num = nums2

        short_num.sort()
        for num in long_num:
            if self.binary_search(short_num, num):
                result.add(num)

        return list(result)
        
    def binary_search(self, num, target):
        start, end = 0, len(num)-1
        while start + 1 < end:
            mid = (start + end) // 2
            if num[mid] <= target:
                start = mid
            if num[mid] > target:
                end = mid

        if num[start] == target or num[end] == target:
            return True

    return False
