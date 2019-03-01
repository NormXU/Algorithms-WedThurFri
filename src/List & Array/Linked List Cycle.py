"""
Given a linked list, determine if it has a cycle in it.



Example
Given -21->10->4->5->21, tail connects to node index 1, return true
"""
"""
设快慢两指针；快指针每次走两步，慢指针每次走一步；若快慢指针最终能够相遇；则说明这是一个闭环
否则就不是闭环
"""
class Solution(object):
	def hasCycle(self, head):
		if head is None:
			return False
		slow = head
		fast = head.next
		while fast is not None and fast.next is not None:
			fast = fast.next.next
			slow = slow.next
			if slow.next == fast.next.next:
				return True
		return False
