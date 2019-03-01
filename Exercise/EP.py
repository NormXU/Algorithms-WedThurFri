1. Find the number of matched substring. 譬如，给一个string = “abc dedef”, target = "de"，要求返回string中match target的subsequence的个数。 以上例子则返回2。就是简单的循环，one-pass 扫一下string就可以了。写完code之后让想了几个test case
2. 给一个数组和一个target number，寻找一个subarray，要求这个subarry的和不大于target number，返回满足这个要求的最长的subarray的长度。比如 nums =  [2, 5, 1, 6, 7, 9], target =9, 则返回 3,因为满足条件的最长subarray是[2, 5, 1]。解法是用两个pointer做一遍scan
3. 一个简单的classification。一个平面上有红蓝两种颜色的点，并且坐标已知。加入一个新的点，要求预测这个新点的颜色。这个题目我之前没见到过，可后来翻了一下前几天的面经，果然也是超高频。扯了neural network, 用 logistic regression做二元的classification。
"""
Find the number of matched substring. 譬如，给一个string = “abc dedef”, target = "de"，要求返回string中match target的subsequence的个数。 以上例子则返回2。就是简单的循环，one-pass 扫一下string就可以了
"""
class Solution(object):

    def Problem1(self, part, txt):
        M = len(part) # substring
        N = len(txt) # Whole String
        cnt = 0

        for i in range(M - N + 1):
            j = 0
            for j in range(M):
                if txt[i+j] != part[j]:
                    break
            if(j == M-1):
                cnt += 1
                j = 0
        return cnt

    def Problem2(self, nums, target):
        length = 0
        for i in range(len(nums)-1):
            sum_tmp = nums[i]
            for j in range(i+1, len(nums)):
                if sum_tmp < target:
                    sum_tmp += nums[j]

                if sum_tmp > target:
                    break
            length = max(length, j - i)

        return length
