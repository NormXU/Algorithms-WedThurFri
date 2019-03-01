"""
Write a function that takes a string as input and returns the string reversed.

Example
Example 1：

Input："hello"
Output："olleh"
Example 2：

Input："hello world"
Output："dlrow olleh"
"""
class Solution:
    """
    @param s: a string
    @return: return a string
    """
    def reverseString(self, s):
        # write your code here
        return s[::-1]

class Solution2:
    str = ""
    for i in s:
        str = i + str
    return str
