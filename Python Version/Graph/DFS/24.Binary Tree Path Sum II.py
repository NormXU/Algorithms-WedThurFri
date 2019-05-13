"""
Your are given a binary tree in which each node contains a value. Design an algorithm to get all paths which sum to a given value. The path does not need to start or end at the root or a leaf, but it must go in a straight line down.

Example
Given a binary tree:

    1
   / \
  2   3
 /   /
4   2
for target = 6, return

[
  [2, 4],
  [1, 3, 2]
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
    @param: root: the root of binary tree
    @param: target: An integer
    @return: all valid paths
    """
    def binaryTreePathSum2(self, root, target):
        # write your code here
        self.result = []
        if root is None:
            return self.result
        subset = []
        index = 0
        self.dfs(target, subset, root, index)

        return self.result

    def dfs(self, target, subset, root, index):
        if root is None:
            return []
        subset.append(root.val)
        tmp = target
        for i in range(index, -1, -1):
            tmp = tmp - subset[i]
            if tmp == 0:
                self.result.append(subset[i:])

        self.dfs(target, subset, root.left, index+1)
        self.dfs(target, subset, root.right, index+1)

        subset.pop()
