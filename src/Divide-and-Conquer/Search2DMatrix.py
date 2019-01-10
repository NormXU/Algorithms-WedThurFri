"""
Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

This matrix has the following properties:

Integers in each row are sorted from left to right.
Integers in each column are sorted from up to bottom.
No duplicate integers in each row or column.
Example
Consider the following matrix:

[
  [1, 3, 5, 7],
  [2, 4, 7, 8],
  [3, 5, 9, 10]
]
Given target = 3, return 2.
"""
class Solution1(object):
	def searchMatrix(self, matrix, target):
		if matrix is None and len(matrix) == 0:
			return 0
		if matrix[0] is None and len(matrix[0]) == 0:
			return 0
		m = len(matrix)
		n = len(matrix[0])
		cnt = 0
		column = n - 1
		row = 0
		while column >=0 and row < m:
			if matrix[row][column] < target:
				column -= 1
			if matrix[row][column] == target:
				cnt += 1
				column -= 1
				row = 0
			if matrix[row][column] > target:
				row += 1