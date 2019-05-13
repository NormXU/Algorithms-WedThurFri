"""
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

Example
Example 1:

Input:[[1,2],[0,3]]
Output:[[0,2],[0,0]]
Example 2:

Input:[[1,2,3],[4,0,6],[7,8,9]]
Output:[[1,0,3],[0,0,0],[7,0,9]]
"""
class Solution:
    """
    @param matrix: A lsit of lists of integers
    @return: nothing
    """
    def setZeroes(self, matrix):
        # write your code here
        if len(matrix) == 0:
            return
        Row = len(matrix)
        Colum = len(matrix[0])

        row = [False for _ in range(Row)]
        col = [False for _ in range(Colum)]



        for i in range(Row):
            for j in range(Colum):
                if matrix[i][j] == 0:
                    row[i] = True
                    col[j] = True

        for i in range(Row):
            for j in range(Colum):
                if row[i] or col[j]:
                    matrix[i][j] = 0
