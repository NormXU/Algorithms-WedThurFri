class Solution:
    """
    @param A: an array
    @return: total of reverse pairs
    """
    """
    归并排序是将数列a[l,h]分成两半a[l,mid]和a[mid+1,h]分别进行归并排序，然后再将这两半合并起来。
    在合并的过程中（设l<=i<=mid，mid+1<=j<=h），当a[i]<=a[j]时，并不产生逆序数；当a[i]>a[j]时，在
    前半部分中比a[i]大的数都比a[j]大，将a[j]放在a[i]前面的话，逆序数要加上mid+1-i。因此，可以在归并
    排序中的合并过程中计算逆序数.
    """
    def reversePairs(self, A):
        # write your code here
        tmp = [0 for _ in range(len(A))]
        self.count = 0
        self.mergeSort(A, 0, len(A)-1, tmp)
        return self.count

    def mergeSort(self, A, start, end, tmp):
        if start >= end:
            return
        mid = (start + end) // 2
        self.mergeSort(A, start, mid, tmp)
        self.mergeSort(A, mid+1, end, tmp)
        self.merge(A, tmp, start, mid, end)

    def merge(self, A, tmp, start, mid, end):
        i = start
        j = mid + 1
        index = start
        while(i <= mid and j <= end):
            if A[i] > A[j]:
                tmp[index] = A[j]
                j += 1
                self.count = self.count + (mid - i + 1)
            else:
                tmp[index] = A[i]
                i += 1

            index += 1

        while i <= mid:
            tmp[index] = A[i]
            i += 1
            index += 1

        while j <= end:
            tmp[index] = A[j]
            j += 1
            index += 1

        for i in range(start, end+1):
            A[i] = tmp[i]
