"""
Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.

Find the number of islands.

Example
Given graph:

[
  [1, 1, 0, 0, 0],
  [0, 1, 0, 0, 1],
  [0, 0, 0, 1, 1],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 1]
]
return 3.
"""
class Solution:
    """
    @param grid: a boolean 2D matrix
    @return: an integer
    """
    
    def numIslands(self, grid):
    	if grid is None or grid[0] is None:
    		return 0

    	nIsland = 0

    	for i in range(len(grid)):
    		for j in range(len(grid[0])):
    			if grid[i][j]:
    				self.bfs(grid, x, y)
    				nIsland += 1

    	return nIsland


    def bfs(self, grid, x, y):
    	from collections import deque
    	queue = deque((x,y))
    	grid[x][y] = False
    	while queue:
    		x, y = queue.popleft()
	    	for (delta_x, delta_y) in [(1,0),(-1,0),(0,1),(0,-1)]:
	    		next_x = x + delta_x
	    		next_y = y + delta_y
	    		if not self.isValid(grid, next_x, next_y):
	    			continue
	    		grid[next_x][next_y] = False
	    		queue.append((next_x,next_y))


    def isValid(self, grid, x, y):
    	m,n = len(grid), len(grid[0])
    	if 0 <= x < m and 0 <= y < n and grid[x][y]:
    		return True
    	return False