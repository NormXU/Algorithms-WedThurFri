"""
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Example
Given root = {1,#,2}, k = 2, return 2.

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
    @param root: the given BST
    @param k: the given k
    @return: the kth smallest element in BST
    """
    def kthSmallest(self, root, k):
    	self.cnt = 0
    	self.value = 0
    	self.helper(root, k)

    	return self.value

    def helper(self, node, k):
    	if node.left:
    		self.helper(node.left, k)
    	self.cnt += 1

    	if self.cnt == k:
    		self.value = node.val

    	if self.cnt < k:
    		if node.right:
    			self.helper(node.right, k)