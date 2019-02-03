"""
You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.

Example
T2 is a subtree of T1 in the following case:

       1                3
      / \              /
T1 = 2   3      T2 =  4
        /
       4
T2 isn't a subtree of T1 in the following case:

       1               3
      / \               \
T1 = 2   3       T2 =    4
        /
       4
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
    @param T1: The roots of binary tree T1.
    @param T2: The roots of binary tree T2.
    @return: True if T2 is a subtree of T1, or false.
    """
    def get(self, root, rt):
        if root is None:
            rt.append("#")
            return
        rt.append(str(root.val))
        self.get(root.left, rt)
        self.get(root.right, rt)

    def isSubtree(self, T1, T2):
        # write your code here
        rt = []
        self.get(T1, rt)
        t1 = ','.join(rt)

        rt = []
        self.get(T2, rt)
        t2 = ','.join(rt)

        return t1.find(t2) != -1
