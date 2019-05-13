"""
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?

Find all unique quadruplets in the array which gives the sum of target.

Example
Example 1:

Input:[2,7,11,15],3
Output:[]

Example 2:

Input:[1,0,-1,0,-2,2],0
Output:
[[-1, 0, 0, 1]
,[-2, -1, 1, 2]
,[-2, 0, 0, 2]]
"""

class Solution:
    """
    @param numbers: Give an array
    @param target: An integer
    @return: Find all unique quadruplets in the array which gives the sum of zero
    """
    def fourSum(self, numbers, target):
        # write your code here
        numbers.sort()
        ans = []

        for i in range(len(numbers) - 3):
            if i and numbers[i] == numbers[i-1]:
                continue
            for j in range( i+1, len(numbers) - 2 ):
                if j != i+1 and numbers[j] == numbers[j-1]:
                    continue

                sumTmp = target - numbers[i] - numbers[j]
                left, right = j+1, len(numbers) - 1
                while left < right:
                    if numbers[left] + numbers[right] < sumTmp:
                        left += 1
                    elif numbers[left] + numbers[right] > sumTmp:
                        right -= 1
                    elif numbers[left] + numbers[right] == sumTmp:
                        ans.append([numbers[i], numbers[j], numbers[left], numbers[right]])
                        right -= 1
                        left += 1

                        while left < right and numbers[left] == numbers[left - 1]:
                            left += 1

                        while left < right and numbers[right] == numbers[right + 1]:
                            right -= 1

        return ans
