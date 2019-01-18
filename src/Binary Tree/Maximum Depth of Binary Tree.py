"""
	Example
		Given a binary tree as follow:

		  1
		 / \ 
		2   3
		   / \
		  4   5  
		The maximum depth is 3.
"""


"""
 思路：整个数的深度 = 左子树和右子树的深度的最大值 + 1
 这是 Divide-and-Conque的方法
"""
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None

class Solution1:
    """
    @param root: The root of binary tree.
    @return: An integer
    """
    def maxDepth(self, root):
    	if root is None:
    		return 0
    	Ldepth = self.maxDepth(root.left)
    	Rdepth = self.maxDepth(root.right)

    	return max(Ldepth, Rdepth) + 1


"""
	遍历所有的Node，根据左右子树是否存在加1
"""
class Solution2:
    """
    @param root: The root of binary tree.
    @return: An integer
    """
    def maxDepth(self, root):
    	if root is None:
    		return 0
    	self.depth = 0
    	self.tranverse(root, 1)
    	return self.depth

    def tranverse(self, curNode, curDepth):
    	if curNode is None:
    		return
    		
    	self.depth = max(self.depth, curDepth)
    	self.tranverse(curNode.left, curDepth+1)
    	self.tranverse(curDepth.right, curDepth+1)