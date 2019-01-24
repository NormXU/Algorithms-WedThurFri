"""
Definition for a undirected graph node
class UndirectedGraphNode:
    def __init__(self, x):
        self.label = x
        self.neighbors = []
"""


def getNodes(self, node):
	from collections import deque
	queue = deque([node])
	visited = set([node])
	while queue:
		head = queue.popleft()
		for neighbor in head.neighbors:
			if neighbor not in visited:
				visited.append(neighbor)
				queue.append(neighbor)

	return visited