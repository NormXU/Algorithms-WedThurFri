"""
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Example
Given s = "abccccdd" return 7

One longest palindrome that can be built is "dccaccd", whose length is 7.
"""
# 构造回文串，各个元素的数目必须都是偶数。因此，元素数为奇数的个元素个数要不就1个，要不1个没有
class Solution(object):
	def longestPalindrome(self, s):
		
		if s is None or len(s) == 0:
			return 0

		hashTable = {}
		for i in s:
			if i in hashTable:
				del hashTable[i]
			else:
				hashTable[i] = True

		numOdd = len(hashTable)
		if numOdd > 0:
			return len(s) - numOdd + 1
		return len(s)
			
	
