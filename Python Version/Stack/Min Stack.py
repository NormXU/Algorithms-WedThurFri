"""
Implement a stack with min() function, which will return the smallest number in the stack.

It should support push, pop and min operation all in O(1) cost.

Example
push(1)
pop()   // return 1
push(2)
push(3)
min()   // return 2
push(1)
min()   // return 1
"""
class MinStack(object):
    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, number):
        self.stack.append(number)
        if not self.min_stack or number <= self.min_stack[-1]:
            self.min_stack.append(number)

    def pop(self):
        element = self.stack.pop()
        if element == self.min_stack[-1]:
            self.min_stack.pop()

        return element

    def min(self):
        return self.min_stack[-1]
