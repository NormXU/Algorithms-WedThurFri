"""
Given a binary tree, find the subtree with maximum average. Return the root of the subtree.

Example
Given a binary tree:

     1
   /   \
 -5     11
 / \   /  \
1   2 4    -2 
return the node 11.
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
    @return: the root of the maximum average of subtree
    """
    def findSubtree2(self, root):
        # write your code here
        self.max = -sys.maxsize
        self.res = None
        self.findSum(root)
        return self.res
    
    def findSum(self, root):
        if root is None:
            return 0,0
        Lsum, Lcount = self.findSum(root.left)
        Rsum, Rcount = self.findSum(root.right)
        Tsum = Lsum + Rsum + root.val
        Tcount = Lcount + Rcount + 1
        if Tsum / Tcount > self.max:
            self.max = Tsum / Tcount
            self.res = root
        return Tsum, Tcount