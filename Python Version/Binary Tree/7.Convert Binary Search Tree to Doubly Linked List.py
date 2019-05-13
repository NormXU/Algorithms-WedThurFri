"""
Example
Given a binary search tree:

    4
   / \
  2   5
 / \
1   3
return 1<->2<->3<->4<->5
"""
"""
Definition of Doubly-ListNode
class DoublyListNode(object):
    def __init__(self, val, next=None):
        self.val = val
        self.next = self.prev = nextDefinition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""

class Solution:
    """
    @param root: The root of tree
    @return: the head of doubly list node
    """
    def bstToDoublyList(self, root):
        # write your code here
        dfs = []
        self.inorder(root, dfs)
        if len(dfs) == 0:
            return None

        head = None
        prev = None
        for val in dfs:
            node = DoublyListNode(val)
            if head is None:
                head = node
            else:
                prev.next = node
            node.prev = prev
            prev = node

        return head


    # Left middle right
    def inorder(self, root, dfs):
        if root is None:
            return
        self.inorder(root.left, dfs)
        dfs.append(root.val)
        self.inorder(root.right, dfs)
