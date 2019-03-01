"""
Reverse a linked list.

Example
Example1:
For linked list 1->2->3, the reversed linked list is 3->2->1
Example2:
For linked list 1->2->3->4, the reversed linked list is 4->3->2->1

Challenge
Reverse it in-place and in one-pass
"""
"""
Definition of ListNode

class ListNode(object):

    def __init__(self, val, next=None):
        self.val = val
        self.next = next
"""
# https://www.youtube.com/watch?v=D7y_hoT_YZI
class Solution:
    """
    @param head: n
    @return: The new head of reversed linked list.
    """
    def reverse(self, head):
        # write your code here
        while head is not None:
            tmp = head.next
            curNode = None
            head.next = curNode
            curNode = head
            head = tmp
        return curNode
