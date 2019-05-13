"""
Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Example
Given root = {1}, target = 0.000000, k = 1, return [1].
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
    @param k: the given k
    @return: k values in the BST that are closest to the target
    """
    def closestKValues(self, root, target, k):
        # write your code here
        ans = self.inorder(root, target)
        ans.sort(key=lambda x:x[1])
        ret = []
        for i in range(k):
            ret.append(ans[i][0])
        return ret
    
    
    def inorder(self, root, target):
        if root is None:
            return []
        return self.inorder(root.left, target) + [[root.val, abs(root.val - target)]] + self.inorder(root.right, target)
