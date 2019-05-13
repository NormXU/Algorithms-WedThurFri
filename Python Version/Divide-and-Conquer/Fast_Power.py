"""
取模运算的规则： (a+b)%c = (a%c +b%c) % c
a^n  = ( a^(n/2) )^2        n是偶数
a^n  = ( a^(n/2) )^2 * a    n是奇数

计算(a^n) % b，其中a，b和n都是32位的非负整数。

"""

class Solution(object):
    """
    @param a, b, n: 32bit integers
    @return: An integer
    """
    def fastPower(self, a, b, n):
    	if n == 0:
    		return 1%b
    	if n == 1:
    		return a%b
    	
    	power = self.fastPower(a,n,n//2)
    	power = (power * power )%b

    	if n%2 == 1: # if n is odd
    		power = ( power * a ) % b

    	return power