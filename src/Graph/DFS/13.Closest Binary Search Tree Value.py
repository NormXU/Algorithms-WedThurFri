"""
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Example
Example1

Input: root = {5,4,9,2,#,8,10} and target = 6.124780
Output: 5
Example2

Input: root = {3,2,4,1} and target = 4.142857
Output: 4
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
    @param target: the given target
    @return: the value in the BST that is closest to the target
    """
    def closestValue(self, root, target):
        # write your code here
        if root is None:
            return None
        
        lower = self.lowerBound(root, target)
        upper = self.upperBound(root, target)
        if lower is None and upper is not None:
            return upper.val
        if upper is None and lower is not None:
            return lower.val
        
        if target - lower.val < upper.val-target:
            return lower.val
        return upper.val
        
    def lowerBound(self, root, target):
        if root is None:
            return None
        
        if target < root.val:
            return self.lowerBound(root.left, target)
        
        lower = self.lowerBound(root.right, target)
        
        return root if lower is None else lower
        
    def upperBound(self, root, target):
        if root is None:
            return None
        if target >= root.val:
            return self.upperBound(root.right, target)
        upper = self.upperBound(root.left, target)
        
        return root if upper is None else upper

