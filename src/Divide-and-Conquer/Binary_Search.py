class Solution1:
    """
    @param nums: An integer array sorted in ascending order
    @param target: An integer
    @return: An integer
    """
    def findPosition(self, nums, target):
        # write your code here
        if len(nums) == 0:
            return -1
            
        if target < nums[0] or target > nums[-1]:
            return -1
            
        start = 0
        end = len(nums) - 1
        return self.binarySearch(nums,target,start,end)
        
    def binarySearch(self, nums, target, left, right):
        
        
        if left > right:
            return -1
        
        mid = (left + right) // 2
            
        if right > left:
            
            if nums[mid] == target:
                return mid
                
            if nums[mid] > target:
                return self.binarySearch(nums,target,left,mid-1)
                
            return self.binarySearch(nums,target,mid+1,right)
        
        if right == left:
            if nums[right] == target:
                return right
            else:
                return -1


class Solution2:
    """
    @param nums: An integer array sorted in ascending order
    @param target: An integer
    @return: An integer
    """
    def findPosition(self, nums, target):
        # write your code here
        if not nums:
            return -1
        
        start = 0
        end = len(nums)-1
        while start <= end:
            mid = (start + end) // 2
            if nums[mid] == target:
                return mid
            if nums[mid] > target:
                end = mid - 1
            if nums[mid] < target:
                start = mid + 1
        return -1


"""
First Position of Target
Example
If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.

"""
# 这里引入Bianry Search的模板
class Solution3:
    """
    @param nums: An integer array sorted in ascending order
    @param target: An integer
    @return: An integer
    """
    def lastPosition(self, nums, target):
        # write your code here
        if nums is None or len(nums) == 0:
            return -1
            
        start = 0
        end = len(nums) - 1
        
        while(start + 1 < end):
            mid = ( start + end ) //2   # 在计算mid的时候，为了防止出现Int的溢出，可以
            # mid = (start + (end - start) ) // 2
            if nums[mid] == target:
                start = mid
            if nums[mid] < target:
                start = mid + 1
            if nums[mid] > target:
                end = mid - 1
        
        # Since we need to return the last element of array        
        if nums[end] == target:
            return end
            
        if nums[start] == target:
            return start
            
        return -1