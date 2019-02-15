"""
Given a string containing n lowercase letters, the string needs to be divided into several continuous substrings, the letter in the substring should be same, and the number of letters in the substring does not exceed k, and output the minimal substring number meeting the requirement.

Example
Example1

Input: s = "aabbbc", k = 2
Output: 4
Explanation:
we can get "aa", "bb", "b", "c" four substring.
Example2

input: s = "aabbbc", k = 3
Output: 3
we can get "aa", "bbb", "c" three substring.
"""
class Solution(object):
    """
    @param s: the string s
    @param k: the maximum length of substring
    @return: return the least number of substring
    """
    def getAns(self, s, k):
        ans = 1
        cnt = 1
        for i in range(1, len(s)):
            if s[i] == s[i-1] and cnt < k:
                cnt += 1
            else:
                ans += 1
                cnt = 1
        return ans
