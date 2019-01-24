"""
Design an iterator over a binary search tree with the following rules:

Elements are visited in ascending order (i.e. an in-order traversal)
next() and hasNext() queries run in O(1) time in average.
Example
For the following binary search tree, in-order traversal by using iterator is [1, 6, 10, 11, 12]

   10
 /    \
1      11
 \       \
  6       12
"""
"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None

Example of iterate a tree:
iterator = BSTIterator(root)
while iterator.hasNext():
    node = iterator.next()
    do something for node 
"""


class BSTIterator:
    """
    @param: root: The root of binary tree.
    """
    # 将左子树所有的点都过一遍，然后压入堆栈
    def __init__(self, root):
    	self.stack = []
    	while root != None:
    		root = root.left


    def hasNext(self):
    	return len(self.stack) > 0


    def next(self):
    	node = self.stack[-1]
    	if node.right is not None:
    		n = node.right
    		while n != None:
    			self.stack.append(n)
    			n = n.left
    	else:
    		n = self.stack.pop()
    		while self.stack and self.stack[-1].right == n:
    			n = self.stack.pop()
    			
    	return node
