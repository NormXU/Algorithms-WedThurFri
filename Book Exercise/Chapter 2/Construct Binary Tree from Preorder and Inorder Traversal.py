"""
Given preorder and inorder traversal of a tree, construct the binary tree.

Example
Given in-order [1,2,3] and pre-order [2,1,3], return a tree:

  2
 / \
1   3
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
    @param inorder: A list of integers that inorder traversal of a tree
    @param postorder: A list of integers that postorder traversal of a tree
    @return: Root of a tree
    """
    def buildTree(self, preorder, inorder):
        if preorder == None or len(preorder) == 0:
            return None

        root = TreeNode(preorder[0])
        post = inorder.index(preorder[0])

        root.left  = self.buildTree(preorder[1:1+post], inorder[:post])
        root.right = self.buildTree(preorder[1+post:], inorder[post+1:])

        return root
