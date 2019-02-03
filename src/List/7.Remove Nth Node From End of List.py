"""
Given a linked list, remove the nth node from the end of list and return its head.

Example
Example 1:
	Input: list = 1->2->3->4->5->null， n = 2
	Output: 1->2->3->5->null


Example 2:
	Input:  list = 5->4->3->2->1->null, n = 2
	Output: 5->4->3->1->null
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
    @param head: The first node of linked list.
    @param n: An integer
    @return: The head of linked list.
    """
    def removeNthFromEnd(self, head, n):
        # write your code here
        dummy = ListNode(0)
        dummy.next = head
        p1 = head
        p2 = dummy
        for _ in range(n):
            p1 = p1.next

        while p1 != None:
            p1 = p1.next
            p2 = p2.next

        p2.next = p2.next.next

        return dummy.next
