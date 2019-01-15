"""
	Design and implement a TwoSum class. It should support the following operations: add and find.

	add - Add the number to an internal data structure.
	find - Find if there exists any pair of numbers which sum is equal to the value.

	Example
	add(1); add(3); add(5);
	find(4) // return true
	find(7) // return false
"""
#天天说hash Table，那么具体的Hash Table该如何实现呢？这道题就是一个例子

class Solution(object):
	def __init__():
		self.count = {}

	def add(self, number):
		if number in self.count:
			self.count[number] += 1
		else:
			self.count[number] = 1


	def find(self, value):
		for num in self.count:
			if value-num in self.count:
				if value-num == num:
					if self.count[num] > 1:
						return True
				else:
					if self.count[num] > 0:
						return True


		return False