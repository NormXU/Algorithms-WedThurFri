"""
Flatten a binary tree to a fake "linked list" in pre-order traversal.


              1
               \
     1          2
    / \          \
   2   5    =>    3
  / \   \          \
 3   4   6          4
                     \
                      5
                       \
                        6

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
    def flatten(self, root):
    	if root is None:
    		return None

    	leftList = self.flatten(root.left)
    	rightList = self.flatten(root.right)

    	if leftList is not None and rightList is not None:
    		leftList.right = root.right
    		root.right = root.left
    		root.left = None

    	if leftList is not None:
    		return leftList

    	if rightList is not None:
    		return rightList

    	return root