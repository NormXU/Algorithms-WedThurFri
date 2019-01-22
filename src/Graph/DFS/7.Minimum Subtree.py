"""
Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.

Example
Given a binary tree:

     1
   /   \
 -5     2
 / \   /  \
0   2 -4  -5 
return the node 1.
"""
"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""

class Solution:
    """
    @param root: the root of binary tree
    @return: the root of the minimum subtree
    """
    def findSubtree(self, root):
    	self.minimum_weight = sys.maxsize
    	self.result = None
    	finSum = self.helper(root)
    	return self.result

    def helper(self, root):
    	if root is None:
    		return 0

    	LeftSum = self.helper(root.left)
    	RightSum = self.helper(root.right)

    	if LeftSum + RightSum + root.val < self.minimum_weight:
    		self.minimum_weight = LeftSum + RightSum + root.val
    		self.result = root

    	return LeftSum + RightSum + root.val


# Divide-and-Conquer

class Solution2(object):
	def findSubtree(self, root):
		minimum, subtree, sum = self.helper(root)
		return subtree

	def helper(self, root):
		if root is None:
			return sys.maxsize, None, 0

		left_minimum, left_subtree, left_sum = self.helper(root.left)
		right_minimum, right_subree, right_sum = self.helper(root.right)

		sum = left_sum + right_sum + root.val
		if left_minimum == min(left_minimum, right_minimum, sum):
			return left_minimum, left_subtree, sum
		if right_minimum == min(right_sum, right_subree, sum):
			return right_minimum, right_subree, sum


		return sum, root, sum
