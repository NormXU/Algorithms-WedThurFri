"""

	Given a binary tree, determine if it is height-balanced.

	For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

	Example
	Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}

	A)  3            B)    3 
	   / \                  \
	  9  20                 20
	    /  \                / \
	   15   7              15  7
	The binary tree A is a height-balanced binary tree, but B is not.

"""
"""
思路：要判断数是否是Balanced的，首先需要计算出左右两树的深度，然后计算左右两数深度差是否满足AVL树的要求 
同理，左节点也有左子树和右子树的存在，当左节点的左右子树是AVL Tree的时候，也就是AND运算，且右子树的左右子树是AVL Tree的时侯，这个树才是真正的AVL Tree

因此这里有两个 Recursion
"""

class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None

class Solution(object):
	"""
    @param root: The root of binary tree.
    @return: True if this Binary tree is Balanced, or false.
    """
    def isBalanced(self, root):
    	if root is None:
    		return True
    	L_Depth = self.maxDepth(root)
    	R_Depth = self.maxDepth(root)
    	if abs(L_Depth - R_Depth) > 1:
    		return False
    	else:
    		return self.isBalanced(root.left) and self.isBalanced(root.right)


    def maxDepth(self, root):
    	if root is None:
    		return 0

    	return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1
		