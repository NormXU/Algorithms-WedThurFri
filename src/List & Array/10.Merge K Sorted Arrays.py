"""
Given k sorted integer arrays, merge them into one sorted array.

Example
Given 3 sorted arrays:

[
  [1, 3, 5, 7],
  [2, 4, 6],
  [0, 8, 9, 10, 11]
]
return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].
"""
# 用 Divide - and - conquer 方法来实现， Merge K 个 Array

class Solution1:
    """
    @param arrays: k sorted integer arrays
    @return: a sorted array
    """
    def mergekSortedArrays(self, arrays):
        # write your code here
        if len(arrays) == 0:
            return []
        if len(arrays) == 1:
            return arrays[0]

        mid = len(arrays) // 2
        left = self.mergekSortedArrays(arrays[0:mid])
        right = self.mergekSortedArrays(arrays[mid:])

        return self.merge_two_array(left, right)

    def merge_two_array(self, arr1, arr2):
        result = []
        i,j = 0, 0
        while i < len(arr1) and j < len(arr2):
            if arr1[i] < arr2[j]:
                result.append(arr1[i])
                i += 1
            else:
                result.append(arr2[j])
                j += 1

        while i < len(arr1):
            result.append(arr1[i])
            i += 1
        while j < len(arr2):
            result.append(arr2[j])
            j += 1

        return result
