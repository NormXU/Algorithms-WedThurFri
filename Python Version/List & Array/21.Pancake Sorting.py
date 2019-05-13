Given an unsorted array, sort the given array. You are allowed to do only following operation on array.

flip(arr, i): Reverse array from 0 to i
Unlike a traditional sorting algorithm, which attempts to sort with the fewest comparisons possible, the goal is to sort the sequence in as few reversals as possible.

Example
Given array = [6, 7, 10, 11, 12, 20, 23]
Use flip(arr, i) function to sort the array.


"""
class FlipTool:
    @classmethod
    def flip(cls, arr, i):
        pass
        ...
"""


class Solution:
    """
    @param array: an integer array
    @return: nothing
    """
    def pancakeSort(self, array):
        # Write your code here
        for target in range(len(array)-1, 0, -1):
            for i in range(target, 0, -1):
                if array[i] > array[0]:
                    FlipTool.flip(array, i)


            FlipTool.flip(array, target)
