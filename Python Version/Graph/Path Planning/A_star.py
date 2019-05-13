class SimpleGraph:
    def __init__(self):
        self.edges = {}

    def neighbors(self, id):
        return self.edges[id]

example_graph = SimpleGraph()
example_graph.edges = {
    'A': ['B'],
    'B': ['A', 'C', 'D'],
    'C': ['A'],
    'D': ['E', 'A'],
    'E': ['B']
}


"""
BFS To search
"""
from collections import *

def bfs(graph, start, goal):
    queue = collections.deque()
    seen = set()

    queue.append(start)
    seen.add(start)

    while len(queue):
        head = queue.popleft()
        print('Visiting %r' % head)

        if head == goal:
            break

        for neighbor in graph.neighbors[head]:
            if neighbor not in seen:
                seen.add(neighbor)
                queue.append(neighbor)

"""
Function with Priority Queue

"""
import heapq

class PriorityQueue(object):
    def __init__(self):
        self.elements = []

    def empty(self):
        return len(self.elements) == 0

    def put(self, item, Priority):
        heapq.heappush(self.elements, (Priority, item))

    def get(self):
        return heapq.heappop(self.elements)[1]
#所以说 PriorityQueue 就是传说中的heap 多加了一项呗……
# heapify的时候，要按照tuple的第一项进行排列，以保证 Min-Heap的性质


def heuristic(a, b):
    (x1, y1) = a
    (x2, y2) = bug
    return abs(x1 - x2) + abs(y1-y2)

def a_star(self, start, goal)：
    queue = PriorityQueue()
    queue.put(start, 0)
    cost_so_far = {}
    came_from = {}
    came_from[start] = None
    cost_so_far[start] = 0

    while len(queue):
        _,current = heapq.heappop(queue)
        if current == goal:
            break

        for next in graph.neighbors[current]:
            new_cost = cost_so_far[next] + graph.cost(current, next)
            if next not in cost_so_far or new_cost < cost_so_far[next]:
                cost_so_far[next] = new_cost
                Priority = new_cost + heuristic(goal, next)
                queue.put(next, Priority)
                came_from[next] = current

    return came_from, cost_so_far

"""
A_star 和 Dijskra的唯一区别就是在于， 压入Priority Queue的时候，
A_star 在Priority这一项上加上了heuristic, 然后再heapify

"""


"""
Version 3
基于Dijskra的重新改版的 A_star
"""
import heapq
from collections import defaultdict
from collections import set

def heuristic(a, b):
    (x1, y1) = a
    (x2, y2) = b
    return abs(x1 - x2) + abs(y1-y2)

def A_star_edited(graph, init, goal):
    prev = {}
    inf = float('inf')
    visited = set()
    dist = defaultdict(lambda:inf)

    dist[init] = 0
    queue = [(dist[u], u) for u in graph.keys()]
    heapq.heapif(queue)

    while queue:
        _, u = heapq.heappop(queue)
        visited.add(u)

        if u == goal:
            break
        for v in graph[u]:
            if v in visited:
                continue
            alt = dist[v] + graph[u][v]
            if alt < dist[v]:
                index = queue.index((dist[v],v))
                queue[index] = ( alt + heuristic(v, goal) , v )
                dist[v] = alt
                prev[u] = v

    return dist, queue
