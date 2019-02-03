"""
Reverse a linked list from position m to n.

Example
Example 1:

Input: 1->2->3->4->5->NULL, m = 2 and n = 4,
Output: 1->4->3->2->5->NULL.
Example 2:

Input: 1->2->3->4->NULL, m = 2 and n = 3,
Output: 1->3->2->4->NULL.
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
    @param head: ListNode head is the head of the linked list
    @param m: An integer
    @param n: An integer
    @return: The head of the reversed ListNode
    """
    def reverseBetween(self, head, m, n):
        # write your code here
        dummy = ListNode(0)
        dummy.next = head
        p1 = dummy
        p2 = head
        for _ in range(m-1):
            p2 = p2.next
            p1 = p1.next

        p1_forze = p1
        p2_forze = p2

        p1 = p1.next
        p2 = p2.next

        for _ in range(n-m):
            tmp = p2.next
            p2.next = p1
            p1 = p2
            p2 = tmp

        p1_forze.next = p1
        p2_forze.next = p2

        return dummy.next
