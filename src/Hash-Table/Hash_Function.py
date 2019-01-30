"""
Example 1:
	Input:  key="abcd", size = 10000
	Output: 978

	Explanation:
	(97*33^3 + 98*33^2 + 99*33 + 100*1)%10000 = 978


Example 2:
	Input:    key="abcd", size = 100
	Output: 78

	Explanation:
		(97*33^3 + 98*33^2 + 99*33 + 100*1)%100 = 78
"""
class Solution:
    """
    @param key: A string you should hash
    @param HASH_SIZE: An integer
    @return: An integer
    """
    def hashCode(self, key, HASH_SIZE):
        # write your code here
        ans = 0
        for x in key:
            ans = ( ans * 33 + ord(x) ) % HASH_SIZE

        return ans
