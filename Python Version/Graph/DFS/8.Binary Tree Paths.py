"""
Given a binary tree, return all root-to-leaf paths.

Example
Example 1:

Input:

   1
 /   \
2     3
 \
  5

Output:


[
  "1->2->5",
  "1->3"
]
Example 2:

Input:

   1
 /   
2     
 

Output:


[
  "1->2"
]
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
    @param root: the root of the binary tree
    @return: all root-to-leaf paths
    """
    def binaryTreePaths(self, root):
    	if root is None:
    		return []
    	self.FinalResult = []
    	self.helper(root,[str(root.val)])
    	return self.FinalResult

    def helper(self, node, path):
    	if node.left:
    		path.append(str(node.left.val))
    		self.helper(node.left, path)
    		path.pop()

    	if node.right:
    		path.append(str(node.right.val))
    		self.helper(node.right, path)
    		path.pop()

    	if node.left is None and node.right is None:
    		self.FinalResult.append('->'.join(path))