"""
Find the middle node of a linked list.

Example
Example 1:
	Input:  1->2->3
	Output: 2
	
	Explanation: 
	return the value of the middle node.
		
Example 2:
	Input:  1->2
	Output: 1
	
	Explanation: 
	If the length of list is  even return the value of center left one.

	快指针每次两步，慢指针每次一步。
	快指针到尾的时候，慢指针就是中点。	
"""

"""
Definition of ListNode
class ListNode(object):
    def __init__(self, val, next=None):
        self.val = val
        self.next = next
"""

class Solution:
    """
    @param head: the head of linked list.
    @return: a middle node of the linked list
    """
    def middleNode(self, head):
    	if head is None:
    		return -1
    	slow = head
    	fast = slow.next
    	if fast is not None and fast.next is not None:
    		slow = slow.next
    		fast = fast.next.next

    	return slow
