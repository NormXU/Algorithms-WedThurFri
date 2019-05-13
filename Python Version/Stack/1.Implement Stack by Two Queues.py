"""
Implement a stack by two queues. The queue is first in first out (FIFO). That means you can not directly pop the last element in a queue.

Example
Example 1:

Input:
push(1)
pop()
push(2)
isEmpty() // return false
top() // return 2
pop()
isEmpty() // return true

"""
class stack(object):
	"""docstring for stack"""
	def __init__(self, arg):
		from collections import deque
		self.queue1 = deque()
		self.queue2 = deque()

	def moveItem(self):
		while len(self.queue1) != 1:
			self.queue2.append(self.queue1.popleft())

	def pop(self):
		self.moveItem()
		self.queue1.popleft()
		self.queue1, self.queue2 = self.queue2, self.queue1

	# Pop()是直接把栈顶的元素扔出去； 而Top()只是返回栈顶的元素，并不把这个元素扔出去
	def top(self):
		self.moveItem()
		item = self.queue1.popleft()
		self.queue1, self.queue2 = self.queue2, self.queue1
		self.queue1.append(item)
		return item


	def isEmpty(self):
		return len(self.queue1) == 0

