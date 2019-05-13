"""
	Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

	Example
	For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:

	(-1, 0, 1)
	(-1, -1, 2)

"""
# 同two sum类似，我们使用template1 来实现3_sum
class Solution:
    """
    @param numbers: Give an array numbers of n integer
    @return: Find all unique triplets in the array which gives the sum of zero.
    """
    def threeSum(self, numbers):
        # write your code here
        numbers.sort()
        ans = []
        for i in range(len(numbers)-2):
            if i and numbers[i] == numbers[i-1]:
                continue
            if numbers[0] > 0:
                break
            start = i+1
            end = len(numbers) - 1
            
            while start < end:
                if numbers[start] + numbers[end] + numbers[i] == 0:
                    ans.append([numbers[i],numbers[start], numbers[end]])
                    start += 1
                    end -= 1
                    while start < end and numbers[start] == numbers[start-1]:
                        start += 1
                    while start < end and numbers[end] == numbers[end+1]:
                        end -= 1
                        
                elif numbers[start] + numbers[end] + numbers[i] < 0:
                    start+=1
                    
                elif numbers[start] + numbers[end] + numbers[i] > 0:
                    end -= 1
        
        return ans

	
