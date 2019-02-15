"""
Insert a node in a sorted linked list.

Example
Example 1:

Input: head = 1->4->6->8->null, val = 5
Output: 1->4->5->6->8->null
Example 2:

Input: head = 1->null, val = 2
Output: 1->2->null
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
    @param head: The head of linked list.
    @param val: An integer.
    @return: The head of new linked list.
    """
    def insertNode(self, head, val):
        dummy = ListNode(0, head)
        p = dummy
        while p.next and p.next.val < val:
            p = p.next

        node = ListNode(val, p.next)
        p.next = node
        return dummy.next
