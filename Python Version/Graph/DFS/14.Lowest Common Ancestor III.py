"""
Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
Return null if LCA does not exist.

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7

"""

"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        this.val = val
        this.left, this.right = None, None
"""


class Solution:
    """
    @param: root: The root of the binary tree.
    @param: A: A TreeNode
    @param: B: A TreeNode
    @return: Return the LCA of the two nodes.
    """
    def lowestCommonAncestor3(self, root, A, B):
    	existA, existB, lca = self.helper(root, A, B)

    	if existA and existB:
    		return lca
    	else:
    		return None


    def helper(self, root, A, B):
    	if root is None:
    		return False, False, None

    	exist_A_left, exist_B_left, lca_left = self.helper(root.left, A, B)
    	exist_A_right, exist_B_right. lca_right = self.helper(root.right, A, B)
    	lca

    	if A == root or B == root:
    		lca = root

    	elif lca_right and lca_left:
    		lca = root
    	elif lca_left and not lca_right:
    		lca = lca_left
    	elif lca_right and not lca_left:
    		lca = lca_right

    	existA = exist_A_left or exist_A_right or root == A
    	existB = exist_B_left or exist_B_right or root == B

    	return existA, existB, lca