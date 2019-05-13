"""
Given two numbers, number a and number b. Find the greatest common divisor of the given two numbers.

Example
Given a = 10, b = 15, return 5.
Given a = 15, b = 30, return 15.


辗转相除法， 又名欧几里德算法， 是求最大公约数的一种方法。它的具体做法是：用较大的数除以较小的数，再用除数除以出现的余数（第一余数），再用第一余数除以出现的余数（第二余数），如此反复，直到最后余数是0为止。如果是求两个数的最大公约数，那么最后的除数就是这两个数的最大公约数。

"""
class Solution(object):
	"""docstring for Solution"""
	def gkd(self, a, b):
		if a is None or b is None:
			return -1
		if a >= b:
			small = b
			big = a
		if a < b:
			small = a
			big = b
		if small != 0:
			return self.gkd(small, big % small)
		if small == 0:
			return big
		