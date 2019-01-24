"""
	   1
	    \
	     2
	    /
	   3

return [1,3,2]

中序遍历（又叫中根遍历）
首先遍历左子树，然后访问根结点，最后遍历右子树。遍历左、右子树时，仍按中序遍历。若二叉树为空则返回。简记为左根右。
上图中序遍历结果是：DBEAFC。
    1
   / \
  2   3
 / \
4   5
return 4 2 5 1 3 
"""
class TreeNode(object):
	"""docstring for TreeNode"""
	def __init__(self, arg):
		this.val = val
		this.left, this.right = None, None
		
class Solution1(object):
    """
    @param root: The root of binary tree.
    @return: Preorder in list which contains node values.
    """
    def inorderTraversal(self, root):
        if root is None:
        	return []

        results = []
        stack = []

        while root:
        	stack.append(root)
        	root = root.left

        while stack:
        	curNode = stack.pop() #先入后出
        	results.append(curNode.val)

        	if curNode.right:
        		curNode = curNode.right
        		while curNode:
        			stack.append(curNode)
        			curNode = curNode.left

        return results




"""
    这种题使用迭代更加简单
"""
class Solution2(object):
    """
    @param root: The root of binary tree.
    @return: Preorder in list which contains node values.
    """
    def inorderTraversal(self, root):
        if root is None:
            return []

        left_posterior = self.inorderTraversal(root.left)
        right_posterior = self.inorderTraversal(root.right)

        return left_posterior + [root.val] + right_posterior