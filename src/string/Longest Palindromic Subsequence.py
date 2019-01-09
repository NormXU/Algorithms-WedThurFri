"""
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
"""
class Solution1:
	"""
	@parameters s: input string
	@ return     : the longest palindromic subsequence
	"""
	def longesrPalindramic(self,s):
		if not s:
			return False
		self.left = 0
		self.maxLength = 0
		for middle in range(len(s)):
			self.find_longest_palindrome_from(s,middle,middle)
			self.find_longest_palindrome_from(s,middle,middle+1)

		return s[self.left:self.left+self.maxLength-1]

	def find_longest_palindrome_from(self, s, left, right):
		while (left >= 0 and right < len(s) and s[left] = s[right]):
			left -= 1
			right += 1
		if self.maxLength < right - left + 1:
			self.maxLength = right - left + 1
			self.left = left + 1