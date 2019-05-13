Give a number of arrays, find their intersection, and output their intersection size.

Example
Given [[1,2,3],[3,4,5],[3,9,10]], return 1

explanation:
Only element 3 appears in all arrays, the intersection is [3], and the size is 1.
Given [[1,2,3,4],[1,2,5,6,7][9,10,1,5,2,3]], return 2

explanation:
Only element 1,2 appear in all arrays, the intersection is [1,2], the size is 2.


class Solution:
    """
    @param arrs: the arrays
    @return: the number of the intersection of the arrays
    """
    def intersectionOfArrays(self, arrs):
        M = {}
        for i in arrs:
            for j in i:
                if j in M:
                    M[j] += 1
                else:
                    M[j] = 1
        ans = 0
        for k,v in M.items():
            if v == len(arrs):
                ans += 1
        return ans
        
