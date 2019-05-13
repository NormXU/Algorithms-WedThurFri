class Solution(object):
	def fibonacci(self, n):
		a = 0
		b = 1
		if n == 1:
			return a
		else:
			for i in range(n-1):
				a,b = b, a+b
			return a
		