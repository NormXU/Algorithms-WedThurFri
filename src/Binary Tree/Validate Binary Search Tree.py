"""
	Given a binary tree, determine if it is a valid binary search tree (BST).

	Assume a BST is defined as follows:

	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.
	A single node tree is a BST


	BST定义：左子树的值都是小于其parent的，右子树的值都是大于等于其parent的
"""

class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None




class Solution:
    """
    @param root: The root of binary tree.
    @return: True if the binary tree is BST, or false
    """
    lastNode = None
    def isValidBST(self, root):
        # write your code here
        if root is None:
            return True
            
        if not self.isValidBST(root.left):
            return False
            
        if self.lastNode and self.lastNode.val >= root.val:
            return False
        
        self.lastNode = root
        if not self.isValidBST(root.right):
            return False
        return True