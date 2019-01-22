"""
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
A single node tree is a BST
Example
An example:

  2
 / \
1   4
   / \
  3   5
The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).
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
    @param root: The root of binary tree.
    @return: True if the binary tree is BST, or false
    """
    lastNode = None
    
    def isValidBST(self, root):
        # write your code here
        if root is None:
            return True
        
        # 你只需要告诉我右边的是不是BST就行了，左边我自己判断
        # 对一个树进行升序遍历， 对其进行中序遍历，遍历的结果如果是升序的，那么这个树一定是BST
        if not self.isValidBST(root.left):
            return False
        
        # 左边就是这么判断的
        if self.lastNode is not None and self.lastNode.val >= root.val:
            return False
            
        self.lastNode = root

        #所以左边就按照我这么判断就行了
        if not self.isValidBST(root.right):
            return False
        
        return True
