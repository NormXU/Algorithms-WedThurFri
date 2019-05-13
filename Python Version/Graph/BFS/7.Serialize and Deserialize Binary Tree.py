"""
Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.

Example
An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:

  3
 / \
9  20
  /  \
 15   7
Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.

You can use other method to do serializaiton and deserialization.
"""

from collections import deque
class Solution:
    """
    @param root: An object of TreeNode, denote the root of the binary tree.
    This method will be invoked first, you should design your own algorithm 
    to serialize a binary tree which denote by a root node to a string which
    can be easily deserialized by your own "deserialize" method later.
    """
    def serialize(self, root):
    	if root is None:
    		return "{}"
    	queue = deque([root])
    	result = [root]

    	while queue:
    		for _ in range(len(queue)):
    			node = queue.popleft()
    			if node is not None:
    				queue.append(node.left)
    				queue.append(node.right)
    				result.append(node.left)
    				result.append(node.right)

    	return '{%s}' % ','.join([str(node.val) if node is not None else '#' for node in queue])
