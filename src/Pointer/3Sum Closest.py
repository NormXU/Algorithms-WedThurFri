"""
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.

Example
For example, given array S = [-1 2 1 -4], and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

"""
class Solution:
    """
    @param numbers: Give an array numbers of n integer
    @param target: An integer
    @return: return the sum of the three integers, the sum closest target.
    """
    def threeSumClosest(self, numbers, target):
        # write your code here
        numbers.sort()
        ans = None
        sum = 0
        
        for i in range(len(numbers)):
            start, end = i+1, len(numbers)-1
            while start < end:
                if start < end and numbers[start] + numbers[end] > target - numbers[i] and end >= 0:
                    if ans is None:
                        ans = abs(numbers[start] + numbers[end] + numbers[i] - target)
                        sum = numbers[start] + numbers[end] + numbers[i]
                    else:
                        if abs(numbers[start] + numbers[end] + numbers[i] - target) < ans:
                            sum = numbers[start] + numbers[end] + numbers[i] 
                            ans = abs(numbers[start] + numbers[end] + numbers[i] - target)
                        
                    end -= 1
                    
                if start < end and numbers[start] + numbers[end] < target - numbers[i] and start <= len(numbers)-1:
                    if ans is None:
                        ans = abs(numbers[start] + numbers[end] + numbers[i] - target)
                        sum = numbers[start] + numbers[end] + numbers[i]
                    else:
                        if abs(numbers[start] + numbers[end] + numbers[i] - target) < ans:
                            sum = numbers[start] + numbers[end] + numbers[i] 
                            ans = abs(numbers[start] + numbers[end] + numbers[i] - target)
                    
                    start += 1
                    
                if start < end and numbers[start]+numbers[end] == target - numbers[i]:
                    return numbers[start]+numbers[end]+numbers[i]
            
            
        return sum
                    
