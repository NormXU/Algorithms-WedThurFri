"""
Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) with a source position, find the shortest path to a destination position, return the length of the route.
Return -1 if destination cannot be reached.

Example
[[0,0,0],
 [0,0,0],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return 2

[[0,1,0],
 [0,0,0],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return 6

[[0,1,0],
 [0,0,1],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return -1
"""
"""
国际象棋的马，根据BFS，求最短路径的方法是：用BFS组合HashTable来记录distance，遍历整个图，一定可以得到最短路径
"""
"""
Definition for a point.
class Point:
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b
"""

class Solution:
    """
    @param grid: a chessboard included 0 (false) and 1 (true)
    @param source: a point
    @param destination: a point
    @return: the shortest path 
    """
    def shortestPath(self, grid, source, destination):
        # write your code here
        from collections import deque
        queue = deque([(source.x, source.y)])
        distance = {(source.x, source.y):0}
        
        while queue:
            x,y = queue.popleft()
            if (x,y) == (destination.x, destination.y):
                return distance[(x,y)]
                
            for delta_x, delta_y in [(1,2),(-1,2),(1,-2),(-1,-2),(2,1),(-2,1),(2,-1),(-2,-1)]:
                next_x = delta_x + x
                next_y = delta_y + y
                if (next_x, next_y) in distance:
                    continue
                if not self.valid(next_x, next_y, grid):
                    continue
                distance[(next_x,next_y)] = distance[(x,y)] + 1
                queue.append((next_x, next_y))
        
        return -1
        
    
    def valid(self, x, y, grid):
        m,n = len(grid), len(grid[0])
        if 0 <= x < m and 0 <= y < n and grid[x][y] == 0:
            return True
        return False
