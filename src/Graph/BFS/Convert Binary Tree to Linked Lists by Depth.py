"""
	Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).

	Example
	Given binary tree:

	    1
	   / \
	  2   3
	 /
	4
	return

	[
	  1->null,
	  2->3->null,
	  4->null
	]
"""

"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        this.val = val
        this.left, this.right = None, None
Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
"""
from collections import deque
class Solution:
    # @param {TreeNode} root the root of binary tree
    # @return {ListNode[]} a lists of linked list
    def binaryTreeToLists(self, root):
        # Write your code here
        if root is None:
            return []
        result = []
        
        queue = deque([root])
        lastNode = None
        dummy = ListNode(0)
        
        while queue:
            dummy.next = None
            lastNode = dummy
            for _ in range(len(queue)):
                curNode = queue.popleft()
                lastNode.next = ListNode(curNode.val)
                lastNode = lastNode.next
                
                if curNode.left:
                    queue.append(curNode.left)
                
                if curNode.right:
                    queue.append(curNode.right)
            
            result.append(dummy.next)
        
        
        return result


"""
1. dummy = ListNode(0)
	0 -> None

2. lastnode = dummy
	0 -> None
3. lastNode.next = ListNode(curNode.val)
	0 -> 2-> None
4. lastNode.next = ListNode(curNode.val)
	0 -> 2 -> 3 -> None
5. Return dummy.next
"""