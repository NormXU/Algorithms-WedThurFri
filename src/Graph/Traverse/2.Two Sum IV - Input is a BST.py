"""
Given a binary search tree and a number n, find two numbers in the tree that sums up to n.

Example
Given a binary search tree:

    4
   / \
  2   5
 / \
1   3
and a number n = 3
return [1, 2] or [2, 1]
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
    @param: : the root of tree
    @param: : the target sum
    @return: two numbers from tree which sum is n
    """

    def twoSum(self, root, n):
        # write your code here
        element = self.inorder(root)

        start, end = 0, len(element) - 1

        while start < end:
            if element[start] + element[end] == n:
                return [element[start], element[end]]
            if element[start] + element[end] < n:
                start += 1
            else:
                end -= 1

        return None


    def inorder(self, root):
        if root is None:
            return []

        left_post = self.inorder(root.left)
        right_post = self.inorder(root.right)

        return left_post + [root.val] + right_post
