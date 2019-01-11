"""
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example
"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.
"""
class Solution:
    """
    @param s: A string
    @return: Whether the string is a valid palindrome
    """
    def isPalindrome(self, s):
        # write your code here
        if s is None:
            return -1
        start = 0
        end = len(s) - 1
        while start < end:
            while not s[start].isdigit() and not s[start].isalpha():
                start += 1
                if start == len(s) - 1:
                    return True
                
            while not s[end].isdigit() and not s[end].isalpha():
                end -= 1
            
            if s[start].lower() != s[end].lower():
                return False
            
            if s[start].lower() == s[end].lower():
                start += 1
                end -= 1
        
        return True

"""
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example
Given s = "aba" return true
Given s = "abca" return true // delete c


依然用相向双指针的方式从两头出发，两根指针设为 L 和 R。
如果 s[L] 和 s[R] 相同的话，L++, R--
如果 s[L] 和 s[R] 不同的话，停下来，此时可以证明，如果能够通过删除一个字符使得整个字符串变成回文串的话，那么一定要么是 s[L]，要么是 s[R]。

"""
class Solution:
    """
    @param s: a string
    @return: nothing
    """
    def validPalindrome(self, s):
        # Write your code here
        if s is None:
            return -1
        start = 0
        flag = 0
        end = len(s) - 1
        while start < end:
            if s[start].lower() == s[end].lower():
                start += 1
                end -= 1
            if s[start].lower() != s[end].lower() and flag == 0:
                start += 1
                flag = 1
                if s[start] != s[end]:
                    start -= 1
                    end -= 1
                if s[start] != s[end]:
                    return False
            if s[start] != s[end] and flag == 1:
                return False
                
        return True
