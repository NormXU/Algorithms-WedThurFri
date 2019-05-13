"""
本题和Fast_Power一样，需要Recursion 和根据n是奇数还是偶数来应用不同的迭代条件

a^n  = ( a^(n/2) )^2        n是偶数
a^n  = ( a^(n/2) )^2 * a    n是奇数


"""
class Solution(object):
    """
    @param x: the base number
    @param n: the power number
    @return: the result
    """
    def myPow(self, x, n):
        # write your code here
        if n == 0:
        	return 1
        if n == 1:
        	return x
        if n < 0:
        	x = 1/x
        	n = abs(n)

        power = self.myPow(x, n//2)
        power = power * power
        if n % 2 == 1:
        	power = power * x

        return power
