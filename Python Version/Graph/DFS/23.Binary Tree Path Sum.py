"""
Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.

A valid path is from root node to any of the leaf nodes.

Example
Given a binary tree, and target = 5:

     1
    / \
   2   4
  / \
 2   3
return

[
  [1, 2, 2],
  [1, 4]
]
"""
"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
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
    @param: root: the root of binary tree
    @param: target: An integer
    @return: all valid paths
    """
    def binaryTreePathSum(self, root, target):
        # write your code here
        result = []
        subset = []
        index = 0
        self.dfs(index, subset, result, root, target)
        return result


    def dfs(self, index, subset, result, root, target):
        if root is None:
            return

        subset.append(root.val)
        index += root.val

        if root.left is None and root.right is None and index == target:
            result.append(subset[:])

        self.dfs(index, subset, result, root.left, target)
        self.dfs(index, subset, result, root.right, target)
        # 已经传入进去了，所以subset中不再需要这个了
        subset.pop()
