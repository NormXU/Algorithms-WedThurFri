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
		while (left >= 0 and right < len(s) and s[left] == s[right]): 
		# 这里很神奇， 如果写错 while (s[left] == s[right] and left >= 0 and right < len(s))，会出现out of string的错误，所以要先对指针进行下检查
			left -= 1
			right += 1
		if self.maxLength < right - left + 1:
			self.maxLength = right - left + 1
			self.left = left + 1