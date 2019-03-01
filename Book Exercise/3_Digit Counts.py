"""
Count the number of k's between 0 and n. k can be 0 - 9.

Example
Example 1:

Input:
k = 1, n = 1
Output:
1
Explanation:
In [0, 1], we found that 1 appeared once (1).
Example 2:

Input:
k = 1, n = 12
Output:
5
Explanation:
"""
class Solution:
    """
    @param k: An integer
    @param n: An integer
    @return: An integer denote the count of digit k in 1..n
    """
    def digitCounts(self, k, n):
        # write your code here
        count = 0
        for i in range(n+1):
            j = i
            while True:
                if j % 10 == k:
                    count += 1
                j = j // 10
                if j == 0:
                    break
        return count
