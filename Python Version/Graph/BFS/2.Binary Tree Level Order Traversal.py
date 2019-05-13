"""
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
"""

class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None

from collections import deque

class Solution:
    """
    @param root: A Tree
    @return: Level order a list of lists of integer
    """
    def levelOrder(self, root):
    	if root is None:
    		return []
    	queue = deque([root])
    	result = []

    	while queue:
    		level = []
    		for _ in range(len(queue)):
    			node = queue.popleft()
    			level.append(node.val)
    			if node.left:
    				queue.append(node.left)
    			if node.right:
    				queue.append(node.right)

    		result.append(level)

    	return result