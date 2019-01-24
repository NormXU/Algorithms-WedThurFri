 """
    1
   / \
  2   3
 / \
4   5

遍历顺序 [4,5,2,3,1]

Given a binary tree, return the postorder traversal of its nodes' values.

Example
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
 

return [3,2,1].
"""

class Solution(object):
	"""docstring for Solution"""
	def __init__(self, val):
		super(Solution, self).__init__()
		self.val = val
		self.left, self.right = None, None


	def  postorderTraversal(self, root):
		if root is None:
			return []

		left_posterior = self.postorderTraversal(root.left)
		right_posteror = self.postorderTraversal(root.right)

		return left_posterior + right_posteror + [root.val]

