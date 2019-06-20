# Binary Search

## Question 1 Classical Binary Search

Time Complexity: O(log n )

```java
int binarySearch(int[] a, int target){
    int left = 0;
    int right = a.length - 1;
    while(left <= right){
        int middle = left + (right - left) / 2;
        if(a[middle] == target){
            return middle;
        }
        else if(a[middle] < target){
            left = middle + 1;
        }
        else {
            right = middle - 1;
        }
    }
    return -1;
}
```

## Question 2: Classical Binary Search in 2D space

若记每一行的元素个数为n

==row = index / n==

==col   = index % n==

 例如： 

1   2   3   4

5   6   7   8

9 10 11 12

比如 *start_Idx* = 0;  *end_Idx* = 11,  *Middle_Idx* = (0 + 11) / 2 = 5

所以 row = 5 / 4 = 1;  col = 5 % 4 = 1; 故middle_Idx 在 （1,  1）



row : matrix.length     col: matrix[0].length

Time Complexity: O(log(m+n))

```java
public boolean ifFind(int[][] matrix, int target){
    if(matrix.length == 0 || matrix[0].length == 0){
        return;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    int i = 0;
    int j = row * col - 1;
    while(i <= j){
        int mid = i + (j - i) / 2;
        int r = mid / row;
        int c = mid % row;
        if(matrix[r][c] == target){
            return true;
        }
        else if (matrix[r][c] < target){
            i = mid + 1;
        } else{
            j = mid - 1;
        }
    }
    return false;
}
```

`

## Question 3 Closest Element To Target

How to find an element that is closest to a Target ?

Target == 4  

indx  0   1   2   3  4

ele   {1,  2 , 3,  8,  9}

我们希望最后剩下两个元素，而离Target距离最近的那个元素就在这两个元素中存在着

```java
public int binarySearch(int[] a, int left, int right, int target){
    while(left + 1 < right){
        int mid = left + (right - left) / 2;
        if(a[mid] == target){
            return mid;
        }
        else if(a[mid] < target){
            left = mid;
        } else{
            right = mid;
        }
    }
    if(Math.abs(a[left] - target) <= Math.abs(a[right] - target)){
        return left;
    }
    else return right;
}
```

## Question 4 First Target

| index | 0    | 1    | 2    | 3    | 4    | 5    | 6    |
| ----- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| A[7]  | 4    | 5    | 5    | 5    | 5    | 5    | 5    |

Iter1: L = 0, R = 6, M = 3

Iter2: L = 0, R = 3, M = 1

这个方法同样是希望在迭代的最后剩下两个元素，然后根据需求去返回答案

```java
int bianrySearch(int[] a, int left, int right, int target){
    while(left+ 1 < right){
        int mid = left = (right - left) / 2;
        if(a[mid] == target){
            return mid;
        } else if(a[mid] < target){
            left = mid;
        } else if(a[mid] >= target){
            right = mid;
        }
    }
    if(a[left] == target){
        return left;
    }
    if(a[right] == target){
        return right;
    }
    return -1;
}
```



## 举一反二， Question 6 Closest K Elements

How to Return the index of k elements that are closeset to the target

Solution1 : 我们可以去找小于target的最大元素，记录它的index，然后根据要求来L-- 或者 R++

{1, 2, 3, 8, 9}

若我们要的target = 4，则先返回3，3是小于4的最大的元素，记为L；  8记为R，根据target需求来L--或者R++

{1   2   3   8   9}

​            L   R

Time Complexity O(log(n) + k)

Question 7 Smallest Elements that is Larger Than Target

{1,3,4,5,8,9}  target = 7  return 8

Case 1: 若input[mid] == Target, left = mid;

Case 2: 若input[mid] > Target,  right = mid;

Case 3: 若input[mid] < Target, left  = mid;

同样的，最后剩下两个元素，再根据需求返回元素的值

if(a[left] > target)   return left

if(a[right] > target)  return right

## 举一反三 Question 8 K-th Smallest in Two Sorted Arrays

Solution 1 谁小移谁

A[] = {2, 5, 7, 10, 13}

B[] = {1, 3, 4, 13, 20, 29}

谁小移谁， Time = O(k)

把A[N]和前B[M]的各自的k/2 进行比较，以每次删除k/2

每一次往前走 k/2 k/4 k/8步

~~xxxxxxxxxxxx~~Xxxxx

​                         a_left

~~yyyyyy~~Yyyyyyyyy

​           b_left



```java
int kth(int[] a, int[] b, int aleft, int bleft, int k){
    if(aleft >= a.length){
        return b[bleft + k - 1];
    }
    if(bleft >= b.length){
        return a[aleft + k - 1];
    }
    if(k == 1){
        return Math.min(a[aleft], b[bleft]);
    }
    
    int amid = aleft + k / 2 - 1;
    int bmid = bleft + k / 2 - 1;
    
    int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
    int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
    
    if(aval <= bval){
        return kth(a, b, amid + 1, bleft, k - k/2);
    } else {
        return kth(a, b, aleft, bmid + 1, k - k/2);
    } 
    
}
```



# Recursion

## Fibonacci sequence

F(0) = 0

F(1) = 1

F(2) = F(0) + F(1)

F(n) = F(n-1) + F(n-2)

```java
int fibo(int n){
    if(n == 0){
        return 0;
    }
    if(n == 1){
        return 1;
    }
    return fibo(n-1) + fibo(n-2);
}
```

分析时间复杂度 Call Stack 

比如说 n == 4

​								    4 

​							/					\ 	

​						3						2

​					/\ 					 /       \ 

​				2     1				 1         0

​       	 /     \

​          1     0

Time

O(1 + 2 + 4 + 8 + ... + 2^n) = O(2^n - 1) (How it comes? 1 + 1 + 2 + 4 + 8 - 1 = 8^2 - 1)

Space: O(n) How many levels of trees does it have ?  Each level is a O(1) space

当有n个items的时候

Trick: 前面所有node的个数的总和都没有最后一层的node的个数多，因此分析comple的时候，往往只看最后一层的node的个数



## How to Calculate a^b

Solution 1: 

2^1000 = 2^999 * 2

Base:2^0 = 1

Recursion Rule: f(n) = a * f(n-1)

Time O(b)

Space O(b)

```java
public int power(int a, int b){
    if(b == 0){
        return 1;
    }
    return a * power(a, b-1);
}
```

The Time Complexity is too high

Solution 2:

a^b = a^(b/2) * a^(b/2)

b为奇数： 2^3 = 2^1 * 2^2

​       		   2^1 = 2^1 * 2^ 0

b为偶数： 2^4 = 2^2 * 2^2

​				   2^2 = 2^1 * 2^1

Base Case 2^1 = 2 2^0 = 1

```java
int power(int a, int b){
    if(b == 0){
        return 1;
    }
    if(b == 1){
        return a;
    }
    int mid = a % b;
    return power(a, mid) * power(a, b - mid);
}
```

Time Complexity Analysis:

​								2^4

​							/			\

​					2^2 				2^2

​			/		\ 					/		\

​		2			2				2				2

   /   \

1      2 ...



​								2^5

​							/			\

​					2^2 				2^3

​			/		\ 					/		\

​		2			2				2^1				2^2

   /   \

1      2 ...

Time O(b) 看树的最后一层

Space O(log b)

但对于每层，我同样的数计算了两次，所以这造成了时间上的浪费

```java
int power(int a, int b){
    if(b == 0){
        return 1;
    }
    int half = power(a, b/2);
    if(b % 2 == 0){
        return half * half;
    }
    if(b % 2 == 1){
        return half * half * a;
    }
}
```

Time: O(log n)

Space: O(log n)

Iteration 1: {-1  -3  7  4}  --> -3 {-1 7 4}

Iteration 2: {-1  -3  7  4}  --> -3 -1 {7 4}

Iteration 3: {-1  -3  7  4}  --> -3 -1 4 7 

两个指针，三个挡板的思想

0  1  2  3

-3 -1 7  4

​     i

​          j

global = 1

```java
int selectionSort(int[] a){
    for(int i = 0; i < a.length - 1; i++){
        int globalMinIdx = i;
        for(int j = i+1; j < a.length; j++){
            if(a[globalMinIdx] > a[j]){
                globalMinIdx = j;
            }
        }
        int tmp = a[i];
        int a[i] = a[globalMinIdx];
        int a[globalMinIdx] = tmp;
    }
}
```

Time O(n^2)

Space O(1)



Given one stack with integers, sort it with two additional stacks (total 2 stacks). 

After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order

global min = 1

cnt = 1

S1 [ 3 

S2 [   4   2           3     

S3 [ 1 

LinkedList<> xx

static 

peek() retirive the first element of list, but not remove

offer

poll

size

isEmpty

```java
public class Solution{
    public void sort(LinkedList<Integer> s1){
        LinkedList<Integer> s2 = new LinkedList<>();
        sort(s1,s2);
    }
    private void sort(LinkedList<Integer> s1,LinkedList<Integer> s2,LinkedList<Integer> s3){
        if(s1.size() <= 1){
            return;
        }
        while(!s1.isEmpty()){
            int tmp = s1.pop();
            while(!s2.isEmpty() && s2.peek() > tmp){
                s1.push(s2.pop());
            }
            s2.push(tmp);
        }
        while(!s2.isEmpty()){
            s1.push(s2.poll());
        }
    }
}
```

array {1, 2, 3}- these elements are not connected in consecutive space, but are connected by pointers/ references



## Array VS LinkedList

Array: Consecutive allocated memory space

LinkedList: not consecutive in memory space, they are connected by reference



Random Access: 	Array: O(1)

​								LinkedList -O(n)



Search Time 		Array: O(n) / O(logn)

​                       		LinkedList O(n) 







## Merge Sort

​										3 1 5 7 9 8 6 4 2 0

​									3 1 5 79    |     8 6 4 2 0

​				3 1 5  | 7 9                                 8 6 4  |  2 0

3 1|  5                   7 | 9                       8 6  | 4            2  | 0

================== ================================== ===================================== =================================================== ==================================== ============================= 

13   5                7  9                             6 8   4              2    0

135                79                                     468                 02



TIme O(n) + O(n/2) + O(n/4) + O(n/8) + .... = O(n)



How many levels:  O(logn)

each level cost :     O(n)

Total Time Complexity:  O(n logn) + O(n)



Space O(1) + O(2) + .....  = O(n)

```java
List<Integer> mergeSort(int[] a, int left, int right){
    if(left == right){
        return Arrays.asList(a[left]);
    }
    int mid = left + (right - left) / 2;
    List<Integer> soluLeft =  mergeSort(a, left, mid);
    List<Integer> soluRight = mergeSort(a, mid+1, right);
    return combine(soluLeft, soluRight);
}
```

combine 就是谁小移谁



A1B2C3D4  === > ABCD 1234



​					A1   B2     C3 D4

​                  /  \     /  \     / \

​             A      1  B    2 C   3





## Quick Select

[0, i] All elements that are smaller than pivot

[i ... j]  Unknown Elements

(j ... n-1]  All elements that are larger than pivot

```java
public int[] quickSort(int[] array){
    if(array == null){
        return;
    }
    quickSort(array, 0, array.length - 1);
    return array;
}

private void quickSort(int[] array, int left, int right){
    if(left >= right){
        return;
    }
    int pivotIdx = partition(array, left, right);
    quickSort(array, left, pivotIdx - 1);
    quickSort(array, pivotIdx+1, right);
}

private int partition(int[] array, int left, int right){
    int pivotIdx = left + (int)(Math.random() * (right - left + 1));
    int pivot = array[pivotIdx];
    swap(array, pivotIdx, right);
    int leftBound = left;
    int rightBound = right - 1;
    while(leftBound <= rightBound){
        if(array[leftBound] < pivot){
            leftBound++;
        } else{
            swap(array, leftBound, rightBound);
            rightBound--;
        }
    }
    swap(array, leftBound, rightBound);
    return leftBound;
}
```

## 

Worst Case

对于一个已经排好序的array，每次random pick都选在最后一个元素

xxxxxxxxxxX   O(n)

xxxxxxxxxXX  O(n-1)

Worst Time:

O(n) + O(n - 1) + .... ==> O(n^2)

Space = O(n)



## Array Shuffling



{1  -4  -5  2  3  2  3}  -- > {1 -4 -5 2 3 0 0}

​                                 f

​                          s



s与f同向而行， f走得快， s走的慢，但他能确保它的左边都是非零的数字

```java
public void shuffle(int[] a){
    
    int s = 0;
    int f = 0;
    while(f < a.length){
        if(a[f] == 0){
            f++;
        }else{
            a[s] = a[f];
            s++;
            f++;
        }
    }
    while(s<a.length){
        a[s] = 0;
        s++;
    }
}
```

## Rainbow Sort

 这个题吧判断标注定位中间那个元素的Index，能够更快的写出代码



```java
public class Solution {
  public int[] rainbowSort(int[] array) {
    // Write your solution here
    if(array == null || array.length <= 1){
      return array;
    }
    // Three boundaries
    // 1. the left side of neg is -1( not include neg) [0, i)
    // 2. the right side of neg is 1                   (k, n-1]
    // 3. between zero and one is unknow zone          [j, k]
    // 4. the part between neg and zero is 0           [i, j]
    int neg = 0;
    int one = array.length - 1;
    int zero = 0;
    while(zero <= one){
      if(array[zero] == -1){
        swap(array, neg, zero);
        neg++;
        zero++;
      }else if(array[zero] == 0){
        zero++;
      }else{
        swap(array, zero, one);
        one--;
      }
    }
    return array;
  }
   public void swap(int[] array, int left, int right){
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }

}
```



Linked List

When you want to dereference a ListNode, make sure it is not a NULL pointer

ListNode p = new ListNode(10);

p.next  // NPE  . is an action that is called de-reference



Reverse Linked List

Iterative Way

```java
public ListNode reverseLinkedList(ListNode head){
    ListNode prev = null;
    while(head != null){
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}
```

Recursive Way

Before: 

   ==Head==              Head.next

Node1  ->   | ..Node 2..

​                

After

​                ==Head==

Null  <=  Node 1 <= | ...

​								



```java
public ListNode reverse(ListNode head){
    if(head == null || head.next == null){
        return head;
    }
    ListNode newHead = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
}
```

- L = null, after reverse is null
- L = 1 -> null, after reverse is 1 -> null
- L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
- L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null

N1  -> N2 -> N3 -> N4 -> null

t



在成对改变Node的时候，完全可以只改变Value的指向

```java
public ListNode reversePair(ListNode head){
    if(head == null){
        return null;
    }
    ListNode tmp = head;
    while(tmp != null && tmp.next != null){
        int k = tmp.value;
        tmp.value = tmp.next.value;
        tmp.next.value = k;
        tmp = tmp.next.next;
    }
    
    return head;
    
}
```

Find the Middle of a LinkedList

N1  N2    null

 s

​         f

```java
public ListNode middleNode(ListNode head){
    if(head == null || head.next == null){
        return head;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while(fast != null || fast.next != null){
        
    }
    
}
```

Judge 一个linkedList是否有环

一个一次走一步，一个一次走两步，若他们中有一天互相追尾，说明：有环存在

```java
public boolean hasCycle(ListNode head){
    if(head == null || head.next == null){
        return head;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while(fast != null || fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
        if(fast == slow){
            return true;
        }
           
    }
    return false;
}
```

Dummy Head Using

N1 -> N2 -> N3 -> N4 -> ..... Nn -> null

(N1 -> Nn) -> (N2 -> Nn-1)  -> ...

Step 1: Find the middle of the linkedList and split it into two halves

Step 2: Reverse the 2nd half of the linkedList

Step 3: merge two LinkedList

```java
private ListNode findMid(ListNode head){
    if(head == null || head.next == null){
        return head;
    }
    ListNode fast = head.next;
    ListNode slow = head;
    while(fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
    }
    return slow;
        
}

private ListNode reverseLink(ListNode head){
    if(head == null || head.next == null){
        return head;
    }
    ListNode prev = null;
    ListNode cur = head;
    ListNode next = null;
    
    while(cur != null){
        next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
    }
    return prev;
}
```

记住要在 the tail of the large list.next == NULL

```java
public class Partition{
    public ListNode partition(ListNode head, int x){
        if(head == null){
            return null;
        }
        ListNode dummySmall = new ListNode(0);
        ListNode dummyLarge = new ListNode(0);
        ListNode curr = head;
        while(curr != null){
            if(cur.val < x){
                dummySmall.next = cur;
                dummySmall = cur;
            } else{
                dummyLarge.next = cur;
                dummyLarge = cur;
            }
            cur = cur.next;
        }
        dummyLarge.next = null;
        dummySmall.next = dummyLarge.next;
        return dummySmall.next;
    }
}
```

Queue & Stack

queue

stack

push()

pop()

top()

Sort with two stack

Given an array that is initially stored in one stack, sort it with one additional stacks (total 2 stacks).

Stack 1: Used for storing all unsorted elements

Stack 2:  left part | right part

```java
public void sort(LinkedList<Integer> s1){
    LinkedList<Integer> s2 = new LinkedList<>();
    sort(s1, s2);
}
private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2){
    if(s1.size() <= 1){
        return;
    }
    int tmp = s1.pop();
    while(! s2.isEmpty() && s2.peek() > tmp){
        s1.push(s2.pop());
    }
    s2.push(tmp);
    while(!s2.isEmpty()){
        s1.push(s2.pop());
    }
    
}
```



# Binary Tree & Binary Search Tree

二叉树的遍历常用的思路就是Recursion，而这个recursion的base case常常是 root == null

**Balanced Binary Tree :** is commonly defined as a binary tree in which the depth of the left and right subtree of every node differ by 1 or less。 

If a tree has n numbers of nodes and it is balanced, then height = O(logn)

**Complete binary tree:** is a binary tree in which every level, except possible the last, is completely filled, and all nodes are as far left as possible



如果一个数是一个满树，则他一定是一个balanced tree



**Binary Search Tree: ** 对于每一个节点，the values in the subleft tree is smaller than its value and the values in its right subtree are all larger than its value.

If we print the value of nodes in the BST in in-order sequence, then it must form an ascending order



主要思路就是，每一个节点想从他的左儿子和右儿子两侧，获得什么？ 并向上返回什么 ?

## Question 1 How to Judge a Binary Tree is Symmetric ?

```java
boolean isSymmetric(TreeNode left, TreeNode right){
    if(left == null && right == null){
        return true;
    }
    if(left == null || right == null){
        return false;
    }
    if(left.value == right.value){
        return false;
    }
    return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
}
```



## Question 2 Judge whether it is a BST

假设： Boundary 是 -MIN_VALUE -- MAX_VALUE。 一个root的左节点的值必须必root的值要小，一个root的右节点的值必须必root的值要大

Time O(n)

Space O(height) 相当于Recursion Tree的高度

```java
boolean isBST(TreeNode root, int min, int max){
    if(root == null)
        return true;
    
    if(root.val <= min || root.val >= max)
        return false;
    return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
}
```





## Question 3 Print BST Tree Keys in the given range

Given two values in k1 and k2 (where k1 < k2) and a root

**Step 1 : Determine Whether we need to go left**

 当 root.value > Lower_bound的时候，可以go left，因为左subtree的值都是比root.value要小的

**Step 2: Determine Whether we need to go right**

当root.value < Upper_bound的时候， 可以go right

```java
void rangeInOrder(TreeNode root, int lower, int upper){
    if(root == null){
        return;
    }
    if(root.val > lower){
        rangeInOrder(root.left, lower, upper);
    }
    if(root.val >= lower && root.val <= upper){
        print(root.val);
    }
    if(root.val < upper){
        rangeInOrder(root.right, lower, upper)
    }
}
```

Time : Worst O(n)

Space: O(height) 





# Heap & Graph Search Algorithms

min Heap; It is a complete binary tree and any nodes are smaller than its descendent

Operations:

1. Insert O(logn)
2. Update O(logn)
3. get/ top:  获得栈顶元素，时间复杂度为O(1)
4. pop: 删除栈顶元素 O(logn)
5. heapify: 使一个unsorted array 变成一个堆， 时间复杂度O(n)

## Question 1: Find Smallest K elements from an unsorted array of size n

Solution 1: 首先对这个unsorted array进行sorted， 然后再取前k个，这个时间复杂度是O(n logn)

Solution 2: 

​					Step 1: Heapify all elements  --> O(n)

​					Step 2: Call pop() k times to get k smallest elements  --> O(k log n)

Time : O(n + k logn)



Solution 3:

​				Step 1: Maintain 一个size为k的max-heap，这个时间需要O(k)

​				Step 2: Iterator over the rest (n - k) elements one by one

​				Step 3: When we traverse a new element, 

​								和你之前维护的minheap的top元素进行比较，如果新的元素比top元素还要小，那么更新。相当于你把之前维护的minheap中的最大的值给换掉了，换成了更小的值，然后再heapify

​								如果比top元素还要大，那么不更新

​			Time : O(k + (n - k) log k)

根节点最小叫Min-Heap;  根节点最大叫Max-Heap



Solution 4: QuickSelect

n = 1000  k = 20

Average Time:  n + n/ 2 + n/4 + .... + 1 = O(n)

Worst Time: O(n^2)

```matlab
function quickSelect(list, left, right, k)

   if left = right
      return list[left]

   Select a pivotIndex between left and right

   pivotIndex := partition(list, left, right, 
                                  pivotIndex)
   if k = pivotIndex
      return list[k]
   else if k < pivotIndex
      right := pivotIndex - 1
   else
      left := pivotIndex + 1
```

```python
import random
def partition(vector, left, right, pivotLeft):
    pivotValue = vector[pivotLeft]
    vector[pivotValue], vector[right] = vector[right], vector[pivotValue]
    storeIdx = left
    for i in range(left, right):
        if vector[i] < pivotValue:
            vector[storeIdx], vector[i] = vector[i], vector[storeIdx]
            storeIdx++;
            
    vector[pivotValue], vector[right] = vector[right], vector[pivotValue]
    return storeIdx

def _select(vector, left, right, k):
    while True:
        pivotIndex = random.randint(left, right)
        pivotNewIdx = partition(vector, left, right, pivotIndex)
        pivotDist = pivotNewIdx - left
        if pivotDist == k:
            return vector[pivotNewIdx]
        if pivotDist > k: //说明K Element在左半侧
            right = pivotNewIdx - 1
        if pivotDist < k: // K Element在右半侧
            left  = pivotNewIdx + 1
            
```

​	





```java
public class KSmallest{
    public int[] smallest(int[] a, int k){
        if(a.length == 0 || k == 0){
            return new int[0];
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>(){
           @Override
            public int compare(Integer o1, Integer o2){
                if(o1.equals(o2)){
                    return 0;
                }
                return o1 > o2 ? -1: 1;
            }
        });
        for(int i = 0; i < array.length; i++){
            if(i < k){
                maxheap.offer(a[i]);
            } else if(maxHeap.peek() > a[i]){
                maxHeap.poll();
                maxHeap.offer(a[i]);
            }
        }
        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--){
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
```

创建Max-Heap

```java
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>(){
    public int compare(Integer o1, Integer o2){
        if(o1.equals(o2)){
            return 0;
        }
        return o1 > o2 ? -1: 1;
    }
});

```



## BFS in graph

Maintain a FIFO queue, put all traversed nodes that haven't been expanded

expand nodes

generate neighbor nodes

do loop until the queue is empty



​							1	

​				        /      \

​					3   		2

​				/    \	   /

​			5      4     7

​		/   \

​    9      11

FIFO = {}

 1

3 2

5 4 7

9 11



Time Complexity = O(n)

Space Complexity = O(n)

```java
public void PrintNodesByLevel(Node root){
    if(root == null){
        return;
    }
    Queue<Node> q = new LinkedList<Node>();
    q.offer(root);
    while(!q.empty()){
        int size = q.size();
        for(int i = 0; i < size; i++){
            Node n = q.poll();
            if(n.left != null){
                q.offer(n.left);
            }
            if(n.right != null){
                q.offer(n.right);
            }
        }
    }
}
```







### Bipartite

Determine if an undirected graph is bipartite. A bipartite graph is one in which the nodes can be divided into two groups such that no nodes have direct edges to other nodes in the same group.

**Examples**

1  --   2

​    /   

3  --   4

is bipartite (1, 3 in group 1 and 2, 4 in group 2).

1  --   2

​    /   |

3  --   4

is not bipartite.

1u  --   2v -- 4u

 \        |

   3v  -- 5u

1 -> u

2,3  -> v

4 -> u



 ================================================================================================================================



Initialize: enqueue 1, color 1 with u

For each step: dequeue the first elements(x) of the queue

Generate: Enqueue all the neighbors(y) and color them with the other color

1. y is generated before

   Case 1.1 y color is different from x color     IGNORE

   Case 1.2  y color is the same as x color       CONFLICT



2. y is not generated before

 ​	color y with the other color than x

 ================================================================================================================================

```java
/**
 * public class GraphNode {
 *   public int key;
 *   public List<GraphNode> neighbors;
 *   public GraphNode(int key) {
 *     this.key = key;
 *     this.neighbors = new ArrayList<GraphNode>();
 *   }
 * }
 */
public class Solution {
  public boolean isBipartite(List<GraphNode> graph) {
    // write your solution here
    HashMap<GraphNode, Integer> visited = new HashMap<GraphNode, Integer>();
    for(GraphNode node: graph){
      if(!BFS(node, visited)){
        return false;
      }
    }
    return true;
  }
  
  private boolean BFS(GraphNode node, HashMap<GraphNode ,Integer> visited){
    if(visited.containsKey(node))
      return true;
    
    Queue<GraphNode> queue = new LinkedList<>();
    queue.offer(node);
    visited.put(node, 0);
    while(!queue.isEmpty()){
      GraphNode cur = queue.poll();
      int curGroup = visited.get(cur);
      int neiGroup = curGroup == 0 ? 1 : 0;
      for(GraphNode nei: cur.neighbors){
        if(!visited.containsKey(nei)){
          visited.put(nei, neiGroup);
          queue.offer(nei);
        }else if(visited.get(nei) != neiGroup){
          return false;
        }
      }
      
    }
    return true;
  }
}

```



### Determine Whether a Binary Tree Is a Complete Binary Tree

Check if a given binary tree is completed. A complete binary tree is one in which every level of the binary tree is completely filled except possibly the last level. Furthermore, all nodes are as far left as possible.

**Examples**

​        5

​      /    \

​    3        8

  /   \

1      4

is completed.

​        5

​      /    \

​    3        8

  /   \        \

1      4        11

is not completed.

   

When the Flag is Off, 当





How to cut/split the number into a minimum number of items such that each item is equal to an integer's square value.

For example 

4 can be split to 1+1+1+1 (4 items) or 2^2 (1 item, which is the solution)
Return 1
10 can be split to two items 3^2 + 1^2 (solution) or four items 2^2 + 2^2 + 1^2 +1^2
Return 2

采用的主要思路是左大段右小段



length 10

—————————   —   1^2



————————       — —   2^2



———————           — — —   3^2

dp[i] = minimum # of perfect squares to sum up 

Base Case dp[0] = 0;  dp[1] = 1;

```java
class Solution{
    // M[i] represents when the number is i. the minimum number of items which are integer's square value
    // Base Case M[0] = 0; M[1]=1
    public int minSplit(int num){
        if(num <= 1){
            return num;
        }
        int[] dp = new int[num + 1];
        for(int i = 1; i <= num; i++){
            dp[i] = i;
            for(j = 1; j*j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
            }
        }
        return dp[num];
    }
}
```







## DFS

Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents), get all the possible ways to pay a target number of cents.

**Arguments**

- coins - an array of positive integers representing the different denominations of coins, there are no duplicate numbers and the numbers are sorted by descending order, eg. {25, 10, 5, 2, 1}
- target - a non-negative integer representing the target number of cents, eg. 99



​                                                                       99

Level 0   25            0* 25    						1* 25  						2 * 25					 	3 * 25

Level 1   10    0 * 10 	 1* 10 ... 9 * 10

Level 2    5

Level 3    1

Time Complexity: O(4^ 99)

```java
public List<List<Integer>> combination(int target, int[] coins){
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    
    findCombination(target, coins, 0, cur, result);
    return resule;
}



private void findCombination(int target, int[] coins, int index, List<Integer> cur, List<List<Integer>> results){
    if(index == coins.length - 1){
        if(target % coins[coins.length - 1] == 0){
            cur.add(target / coins[coins.length - 1]);
            result.add(new ArrayList<Integer>(cur));
            cur.remove(cur.size()-1);
        }
    }
    int max = target / coins[index];
    for(int i = 0; i <= max; i++){
        cur.add(i);
        findCombination(target - i*coins[index], coins, index+1, cur, results);;
        cur.remove(cur.size()-1);
    }
}
```

Given a set of characters represented by a String, return a list containing all subsets of the characters.

**Assumptions**

- There are no duplicate characters in the original set.

**Examples**

- Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
- Set = "", all the subsets are [""]
- Set = null, all the subsets are []



Level 0  有a 没有a

Level 1  有b 没有b

Level 2  有c 没有c

```java
public List<String> subset(String set){
    List<String> result = new ArrayList<>();
    if(set == null){
        return result;
    }
    char[] arrayChar = set.toCharArray();
    StringBuilder sb = new StringBuilder();
    helper(0, sb, result, arrayChar);
    return result;
}

private void helper(int index, StringBuilder sb, List<String> result, char[] arrayChar){
    if(index == arrayChar.length){
        result.add(sb.toString);
        return;
    }
    helper(index + 1, sb.append(arrayChar[index], result, arrayChar));
    sb.deleteCharAt(sb.length()-1);
    helper(index+1, sb, resuly, arrayChar);
    
}
```

Time  : O(2^n)

Space:  O(n)





Given N pairs of parentheses “()”, return a list with all the valid permutations.

**Assumptions**

- N > 0

**Examples**

- N = 1, all valid permutations are ["()"]
- N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]

```java
public List<String> valid(int n){
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    
    helper();
    return result;
}
private void helper(List<String> result, StringBuilder sb, int l, int r, int n){
    if(l == n && r == n){
        result.add(sb.toString());
        return;
    }
    if(l < n){
        helper(result, sb.append('<'), l+1, r, n);
        sb.deleteCharAt(sb.length() - 1);
    }
    if(r < l){
        helper(result, sb.append('>'), l, r+1, n);
        sb.deleteCharAt(sb.length() - 1);
    }
    
}


```

Given a string with no duplicate characters, return a list with all permutations of the characters.

Assume that input string is not null.

**Examples**

Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]

Set = "", all permutations are [""]



Time: O(n!)

Space O(n)

​									abc

​             swap(0,0)   swap(0,1)  swap(0,2)

0, 1, 2     abc   			bac  			cba

 i = 0 j = 0, 1, 2



abc     acb          bac 	bca       cba 	cab

i = 1   i = 1

j = 1   j = 2



```java
public List<String> permutation(String set){
    if(set == null){
        return null;
    }
    char[] arrayChar = set.toCharArray();
    helper(array, 0, result);
    return result;
}

private void helper(char[] array, int index, List<String> result){
    if(index == array.length){
        result.add(new String(array));
        return;
    }
    for(int i = index; i < array.length; i++){
        swap(array, i, index);
        helper(array, index + 1, result);
        swap(array, i ,index);
    }
}
```



Hash Table & String

<Key,  Value> pairs, not allow duplicate keys

常用API

```java
HashMap<String, Integer> votes = new Hashmap<String, Integer>();
int vote = votes.get(name);
vote++;
vote.put(name, vote);
```

```c++
std::unsorted_map<string, int> votes;
votes[name]++;
```

.get(key)  			 -O(n)

.put(key, value)   - O(m)



== ===== = = = = = = = == =  = = = =================================== =============== =============  === == =  = = = = = = = = = = = == = = = =  = == == = 

Given a composition with different kinds of words, return a list of the top K most frequent words in the composition.

**Assumptions**

- the composition is not null and is not guaranteed to be sorted
- K >= 1 and K could be larger than the number of distinct words in the composition, in this case, just return all the distinct words

**Return**

- a list of words ordered from most frequent one to least frequent one (the list could be of size K or smaller than K)

**Examples**

- Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [“b”, “c”]
- Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [“b”, “c”, "a", "d"]
- Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [“b”, “c”, "a", "d"]

Step 1: Iterate over the composition and for each word, count its frequency. 

Step 2: Flatten the hashtable into an array

Step 3: maintain a Min Heap whose size is k

```java
public String[] topKFrequency(String[] comb, int k){
    if(combo.length == 0){
        return new String[0];
    }
    Map<String, Integer> freqMap = getFreqMap(comb);
    // Map.Entry is a key and its value combined into one class.
    PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
   public int compare(map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
       return e1.getValue().compareTo(e2.getValue());
   };
   for(Map.Entry<String, Integer> entry: freq,entrySet()){
       if(minHeap.size() < k){
           minHeap.offer(entry);
           
       }else if(entry.getvalue() > minHeap.peek().getValue()){
           minHeap.poll();
           minHeap.offer(entry);
       }
       
    String[] result = new String[minHeap.size()];
    for(int i = minHeap.size() - 1l i >= 0; i--){
        result[i] = minHeap.poll().getKey();
    }
       return result;
       
   }
        
     
}

private Map<String, Integer> getFreqMap(){
    Map<String ,Integer> freqMap = new HashMap<>();
    for(String s: comb){
        Integer freq = freqMap.get(s);
        if(freq == null){
            freqMap.put(s, 1);
        }else{
            freqMap.put(s, freq+1);
        }
    }
    return freqMap;
}
```





## Dynamic Programming

Given a rope with positive integer-length *n*, how to cut the rope into *m* integer-length parts with length *p*[0], *p*[1], ...,*p*[*m*-1], in order to get the maximal product of *p*[0] **p*[1]* ... **p*[*m*-1]? *m* **is determined by you** and must be greater than 0 **(at least one cut must be made**). Return the max product you can have.

**Assumptions**

- n >= 2

**Examples**

- n = 12, the max product is 3 * 3 * 3 * 3 = 81(cut the rope into 4 pieces with length of each is 3).

```java
public int cutRope(int m){
    int[] M = new int[n+1];
    M[0] = 0;
    M[1] = 0;
    for(int i = 2;i<= n; i++){
        int curMax = 0;
        for(int j = 1; j<i;j++){
            curMax = Math.max(curMax, Math.max(j, M[j] * (i-j)));
            M[i] = curMax;
        }
    }
    return M[n];
}
```

