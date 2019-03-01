"""
Determine the number of bits required to flip if you want to convert integer n to integer m.

Example
Example 1:
	Input: n = 31, m = 14
	Output:  2

	Explanation:
	(11111) -> (01110) there are two different bits.


Example 2:
	Input: n = 1, m = 7
	Output:  2

	Explanation:
	(001) -> (111) will change two bits.
"""
class Solution:
    """
    @param a: An integer
    @param b: An integer
    @return: An integer
    """
    def bitSwapRequired(self, a, b):
        # write your code here
        c = a ^ b
        cnt = 0
        # ^ 是异或的意思
        # 异或完毕之后，每次都与1进行AND，观察结果 eg: 00001， 00010， 00100， 01000
        for i in range(32):
            if c & (1 << i) != 0:
                cnt += 1
        return cnt
