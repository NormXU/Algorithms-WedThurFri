"""
Given a string which contains only letters. Sort it by lower case first and upper case second.

Example
For "abAcD", a reasonable answer is "acbAD"

Challenge
Do it in one-pass and in-place.

Notice
It's NOT necessary to keep the original order of lower-case letters and upper case letters.
"""
class Solution:
    """
    @param: chars: The letter array you should sort by Case
    @return: nothing
    """
    def sortLetters(self, chars):
        # write your code here
        if chars is None or len(chars) <= 1:
            return chars

        # QuickSort
        start, end = 0, len(chars) - 1
        while start <= end:
            while start <= end and chars[start].islower():
                start += 1
            while start <= end and chars[end].isupper():
                end -= 1

            if start <= end:
                chars[start], chars[end] = chars[end], chars[start]
                start += 1
                end -= 1

        return chars
