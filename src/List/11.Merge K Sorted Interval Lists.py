"""
Merge K sorted interval lists into one sorted interval list. You need to merge overlapping intervals too.

Example
Given

[
  [(1,3),(4,7),(6,8)],
  [(1,2),(9,10)]
]
Return

[(1,3),(4,8),(9,10)]
"""
"""
Definition of Interval.
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    """
    @param intervals: the given k sorted interval lists
    @return:  the new sorted interval list
    """
    def mergeKSortedIntervalLists(self, intervals):
        # write your code here
        if len(intervals) == 0:
            return []
        if len(intervals) == 1:
            return intervals[0]

        mid = len(intervals) // 2
        left = self.mergeKSortedIntervalLists(intervals[0:mid])
        right = self.mergeKSortedIntervalLists(intervals[mid:])

        return self.mergeTwoArray(left, right)

    def mergeTwoArray(self, left, right):
        i, j = 0, 0
        ans = []

        while i < len(left) and j < len(right):
            if left[i].start < right[j].start:
                self.push_back(ans, left[i])
                i += 1
            else:
                self.push_back(ans, right[j])
                j += 1

        while i < len(left):
            self.push_back(ans, left[i])
            i += 1

        while j < len(right):
            self.push_back(ans, right[j])
            j += 1

        return ans

    def push_back(self, ans, tmp):
        if not ans:
            ans.append(tmp)
            return ans

        last_value = ans[-1]
        if last_value.end < tmp.start:
            ans.append(tmp)
            return ans

        ans[-1].end = max(ans[-1].end, tmp.end)
