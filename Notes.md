# June 20

## Question 1

Given an unsorted array, find the subarray whose sum is the largest

a         2   -1   4   -7    1   6  

m        2

GM =  2

```java
public int maxValue(int[] array){
   int GlobalMax =  array[0];
   int[] m = new int[array.length];
    m[0] = array[0];
    for(int i = 1; i < array.length; i++){
        m[i] = Math.max(m[i-1] + array[i], array[i]);
        GlobalMax = Math.max(GlobalMax, array[i]);
    }
    return GlobalMax;
}
```

Follow Up

Subarray leftBoundary, rightBoundary

a      2   -1   4   -7    1   6  

m     2   1   5    -3    1  7

gM = 5

​	 	                     gL

​	 	                            gR

​		                      cL

​		                           cR

```java
public int maxValue(int[] array){
   int GlobalMax =  array[0];
   int[] m = new int[array.length];
    m[0] = array[0];
    int gL = 0;
    int gR = 0;
    int cL = 0;
    for(int i = 1; i < array.length; i++){
        if(m[i-1]+array[i] < array[i]){
            cL = i;
            m[i] = array[i];
        } else{
            m[i] = m[i-1]+array[i];
        }
        if(m[i] > GlobalMax){
            GlobalMax = m[i];
            gL = cL;
            gR = i;
        } 
       
    }
    return new int[]{gL, gR};
}
```



## Question 2

615. **Course Schedule**

There are total of n courses you have to take, labeled from 0 to n-1

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair:[0,1]

given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

**example 1**

Input: n = 2, prerequisites = [[1,0]]

[0,1]

output: true

**example 2**

Input: n = 2, prerequisites = [[1,0],[0,1]]

output: false

**example3**

Input: n = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]

[0,1,2,3] or [0,2,1,3]

output: True

​	 0

   /     \

1         2

   \      /

​      3

edges: {0:[1,2], 1:[3], 2:[3], 3:[]}

degree:[2, 1, 1, 0]

Hint:把入度为0的课程加入队列中，再从队列中popleft时，把它所指向的课程的入度减去1

Queue 队列中都是入度为0的课程，也就是

```python
from collections import deque
def finishClass(numCourses, prerequests):
    edges = {i:[] for i in range(numCourses)}
    degree = [0 for i in range(numCourses)]
    for i,j in prerequests:
        edges[j].append(i)
        degree[j] += 1
    queue = deque([])
    count = 0
    for i in range(numCourses):
        if degree[i] == 0:
            queue.append(i)
    while queue:
        node = queue.popleft()
        count += 1
        for x in edges[node]:
            degree[x] -= 1
            if degree[x] == 0:
                queue.append(x)
    return count == numCourses
```



## Question 3

433. **Number of Islands**

Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. if two 1 is adjacent, we consider them in them in the same island. we only consider up/down/left/right adjacent.

find the number of islands.

**example 1**

Input:

[ 

 [1,1,0,0,0],

 [0,1,0,0,1],

 [0,0,0,1,1],

 [0,0,0,0,0],

 [0,0,0,0,1]

]

Output:

3

**example2**

Input:

[

 [1,1]

]

output:

1

Hint：把已经检查过的为1的点放入visited里面，记住队列里面不要放重复的点

```python
class Solution:
  def Islands(self,grid):
    islands = 0
    visited = set()
    for i in range(len(grid(1))):
      for j in range(len(grid(0))):
        if grid[i][j]==1 and (i,j) not in visited:
          self.bfs(grid,i,j,visited)
          islands +=1
     return islands
   def bfs(self,grid,x,y,visited):
    queue = deque([(x,y)])
    visited.append((x,y))
    n ,m = len(grid[0]),len(grid[1])
    while queue:
      x,y = queue.popleft()
      for dx,dy in [(-1,0),(1,0),(0,-1),(0,1)]:
        next_x = x+dx
        next_y = y+dy
        if next_x,next_y in visited:
          continue
        if next_x<0 or next_x>=n or next_y<0 or next_y >=m or grid[next_x][next_y]==0:
          continue
        queue.append((next_x,next_y))
        visited.add((next_x,next_y))
```





## 4 One Edit Distance

**Examples:**

s = "abc", t = "ab" are one edit distance since you can remove the trailing 'c' from s so that s and t are identical

s = "abc", t = "bcd" are not one edit distance



1. 处理String的Length，当s的length和t的length的差大于1的时候，那么永远不可能通过one edit来获得改变后的结构

2. 当s的length和t的length的差 == 1，  说明可以通过删减来实现

   当两指针所对应的元素不相同的时候，slow -- ，然后再把Flag设为true，告诉程序，已经发生过一次delete/replace了

   a b c d

   ​      f

   a b d

   ​      s

   

3. 当s的length和t的length的差 == 0的时候，说明通过replace来实现

当两指针所对应的元素不相同的时候，然后再把Flag设为true，告诉程序，已经发生过一次delete/replace了

```java
public class Solution {
  public boolean oneEditDistance(String source, String target) {
    // Write your solution here
    if(source == null && target == null){
      return true;
    }
    if(source == null || target == null){
      return false;
    }
    int m = source.length();
    int n = target.length();
    if(m-n == 0){
      return checkReplace(source, target);
    }else if(m - n == 1){
      return checkRemove(source, target);
    }else if(n - m == 1){
      return checkRemove(target, source);
    }
    return false;
  }

  private boolean checkReplace(String s, String t){
    // s is the one whose length is larger
    // t is the one whose length is shorter
    int m = s.length();
    boolean flag = false;
    for(int i = 0; i < m; i++){
      if(s.charAt(i) != t.charAt(i)){
        if(flag){
          return false;
        }else{
          flag = true;
        }
      }
    }
    return flag;
  }

  private boolean checkRemove(String s, String t){
    // s is the one whose length is larger
    // t is the one whose length is shorter
    
    int n = t.length();
    boolean flag = false;
    int fast=0;
    for( int slow = 0; slow < n; slow++){
      if(s.charAt(fast) != t.charAt(slow)){
        if(flag){
          return false;
        }
        flag = true;
        slow--;
      }
      fast++;
    }
    return true;
  }
}

```



## Question 5 

Find the maximum possible sum from one leaf node to another 必须是从一个leaf到达另一个leaf

Recursion Three Steps
1. What do you want from lchild and rchild
  - Max Single Path with leaf node in my left subtree
  - Max Single Path with leaf node in my right subtree

2. In the current layer
  - if root.left != null && root.right != null:
        update global max with (1) + (2) + root.value

3. What do you want to report to your parent
  - max((1), (2)) + root.value


  Examples

  -15

  /    \

2      11

 	/    \

​	6     14



​		11

​	/  		 \

  6    		-4

The maximum path sum is 6 + 11 + 14 = 31.

根节点是肯定要选定的，而下一个level用来返回 left-sub /  right-sub

```java
  public int maxPathSum(TreeNode root) {
    int[] result = new int[]{Integer.MIN_VALUE};
    MaxPathSum(root,result);
    return result[0];
  }

 private int MaxPathSum(TreeNode root, int[] globalMax){

      if(root == null){
          return 0;
      }

      int lcost = MaxPathSum(root.left, globalMax);
      int rcost = MaxPathSum(root.right, globalMax);
      int cursum = lcost + rcost + root.key;

      if(cursum > globalMax[0] && (root.left != null && root.right != null)){

          globalMax[0] = cursum;

      }

      if(root.left==null){
          return root.key+rcost;
      } else if(root.right == null){
          return root.key+lcost;
      }

      return Math.max(lcost,rcost)+root.key;
  }
```



## Question 6

Given a binary tree in which each node contains an integer number. Find the maximum possible subpath
sum(both the starting and ending node of the subpath should be on the same path from root to one of the leaf nodes,
and the subpath is allowed to contain only one node).

**Assumptions**

The root of given binary tree is not null
Examples

   -5

  /    \

2      11

 	/       \

​	6       14

​       	/

​       -3

The maximum path sum is 11 + 14 = 25

```java
public int maxPathSum(TreeNode root) {
    int[] max = new int[]{Integer.MIN_VALUE};
    helper(root, max);
    return max[0];
  }

private int helper(TreeNode root, int[] result){
    if(root == null){
        return 0;
    }
    int leftValue  =  helper(root.left, result);
    int rightValue =  helper(root.right, result);
    int sin   = Math.max(Math.max(leftValue, rightValue), 0);
    result[0] = Math.max(result[0], sin);
}
```



## Question 7

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.  


**Example**


Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)


Output: 7 -> 0 -> 8

```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}
```





## Question 8

Find all pairs of elements in a given array that
sum to the pair the given target number. Return all the distinct pairs of values.
     0  1  2  3  4  5  6  7
A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]

```java
public List<List<Integer>> allPairs(int[] array, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, Integer> Map = new Hashmap<>();
    for(int num : array){
        Integer count = Map.get(num);
        if(num * 2 == target && count != null && count == 1){
            result.add(Arrays.asList<num, num>);
        } else if(map.containsKey(target - num) && count == null){
            result.add(Arrays.asList<target-num. num>);
        }
        if(count == null){
            Map.put(num, 1);
        }else {
            Map.put(num, count + 1)
        }
    }
    return result;
}
```





## Question 9  祖玛

Given an unsorted integer array, remove adjacent duplicate elements repeatedly,
from left to right. For each group of elements with the same value do not keep any of them.

Examples

{1, 2, 3, 3, 3, 2, 2} → {1, 2, 2, 2} → {1}, return {1}

-1  0  1  2  3  4  5  6

​      1  2  3  3  3  2  2

​      e

​                                i

O(n)

```java
public int[] dedup(int[] array) {
    int end = -1;
    for(int i = 0; i < array.length; i++){
        if(end == -1 || array[end] != array[i]){
            end++;
            array[end] = array[i];
        }else{
            while(i+1 < array.length && array[i+1] == array[end]){
                i++;
            }
            end--;
        }
        return Arrays.copyOf(array, end+1);
    }
    
    
}
```

[... e] The array that never exits any duplicate elements

[e .. s] May Exist Duplicate Elements

[s .. ]  Unknown Elements





## Question 10 Kth Smallest in Two Sorted Arrays

Given *n* pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given *n* = 3, a solution set is:

```
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```

Time O(4^N)

Space O(4^N)

DFS

```c++
vector<string> generateParaenthesis(int n){
    string tmp;
    vector<string> result;
    
}
void dfs(int n, int left, int right, vector<string>& result, string tmp){
    if(left == n && right == n){
        result.push_back(tmp);
        return;
    }
    if(left < n){
        dfs(n, left+1, right, result, tmp + '(');
    }
    if(left > right){
        dfs(n, left, right + 1, result, tmp + ')');
    }
    
}
```





## Question 11 九宫格数字键

Given a string containing digits from `2-9` inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].



```c++
vector<string> letterCombination(string digits){
    vector<string> result;
    string output;
    if(digits.length() == 0){
        return result;
    }
    map<char, string> myMap{{'2', 'abc'}, {}, {},...};
    int cur = 0;
    dfs();
}
void dfs(int cur, string output, vector<string>& result, map<char, string> myMap){
    if(output.length() == digits.length()){
        result.push_back(output);
        return;
    }
    string x = myMap[digits[cur]];
    for(int i = 0; i < x.length(); i++){
        output.push_back(x[i]);
        dfs(myMap, output, result, digits, cur + 1);
        output.pop_back();
    }
    
}
```

```java
public List<String> letterCombination(string digits){
    List<String> result;
    StringBuilder sb = new StringBuilder();
    if(digits.length() == 0){
        return result;
    }
    Map<char, string> myMap = new hashMap<>();
    int cur = 0;
    dfs();
    return result;
    
}
private void dfs(int cur, List<String> result, Map<char, string> myMap, StringBuilder sb, string digits){
    if(sb.length == digits.length()){
        result.add(sb.toString());
        return;
    }
    string x = myMap[digits[cur]];
    for(int i = 0; i < x.length(); i++){
        sb.append(x[i]);
        dfs(cur+1, result, myMap, sb, digits);
        sb.deleteCharAt(i);
    }
    
}
```





​									

## Question 12 Duplicate Characters

Given a string with **duplicate** characters, return a list with all permutations of the characters.

Assume that input string is not null.

**Examples**

Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]

Set = "", all permutations are [""]



​			 aac

​				aac 	  		aac 			 caa      	  	  HashSet  1  =  aac  caa

level 0 

​		aac  	aca 	aac  	aca 	caa  	caa    	HashSet   2 = 



​								abab

​	(a) bab  (b)aab ~~(a)bab (b)baa~~	HashSet

   a bab aabb									HashSet



Every Iteration call back, we apply an HashSet



Space Complexity: 

numbers  of Levels:

Space :  O(n^2) = O(n + (n-1) + (n-2) + .... + 1 ) 也就是每个元素都不一样的情况下，第一层level需要length = n的Space当做HashSet，第二层需要Length = n-1 的Space来作HashSet

Time   :  O(n!)







```java
public List<String> permutation(String set){
    if(set == null){
        return null;
    }
    List<String> result = new ArrayList<>();
    char[] arrayChar = set.toCharArray();
    helper();
    return result;
}

private void helper(char[] arrayChar, List<String> result, int idx){
    if(idx == arrayChar.length()){
        result.add(new String(arrayChar));
        return;
    }
    Set<Chacacter> used = new HashSet<>();
    for(int i = idx+ 1; i < arrayChar.length; i++){
        if(used.add(arrayChar[i])){
            swap(chars, i, level);
            helper(arrayChar, result, idx+1);
        	swap(arrayChar, idx, i);
        }
        
    }
    
}
```

