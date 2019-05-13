"""
Invert a binary tree.

Example
  1         1
 / \       / \
2   3  => 3   2
   /       \
  4         4
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
    @param root: a TreeNode, the root of the binary tree
    @return: nothing
    """
    def invertBinaryTree(self, root):
    	if root is None:
    		return {}
    	self.dfs(root)

    def dfs(self, node):
    	left = node.left
    	right = node.right
    	node.left = right
    	node.right = left

    	if node.left is not None:
    		self.dfs(node.left)

    	if node.right is not None:
    		self.dfs(node.right)

