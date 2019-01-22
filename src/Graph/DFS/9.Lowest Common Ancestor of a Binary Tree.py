"""

Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

Example
For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7

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
    @param: root: The root of the binary search tree.
    @param: A: A TreeNode in a Binary.
    @param: B: A TreeNode in a Binary.
    @return: Return the least common ancestor(LCA) of the two nodes.
    """
    def lowestCommonAncestor(self, root, A, B):
    	if root is None:
    		return None

    	if root is A or root is B:
    		return root

    	leftAscendor = self.lowestCommonAncestor(root.left, A, B)
    	rightAscendor = self.lowestCommonAncestor(root.right, A, B)

    	if leftAscendor is not None and rightAscendor is not None:
    		return root
    	if leftAscendor is None:
    		return rightAscendor
    	if rightAscendor is None:
    		return leftAscendor