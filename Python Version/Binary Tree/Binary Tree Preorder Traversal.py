 """
    1
   / \
  2   3
 / \
4   5

先遍历顺序 [1,2,4,5,3]

"""
class TreeNode(object):
	"""docstring for TreeNode"""
	def __init__(self, arg):
		this.val = val
		this.left, this.right = None, None

class Solution(object):
    """
    @param root: The root of binary tree.
    @return: Preorder in list which contains node values.
    """
    def preorderTraversal(self, root):
    	if root is None:
    		return []
		stack = [root]
		Preorder = []
		while stack:
			node = stack.pop()
			Preorder.append(node.val)
			if node.right:
				stack.append(node.right)
			if node.left:
				stack.append(node.left)
		return Preorder
