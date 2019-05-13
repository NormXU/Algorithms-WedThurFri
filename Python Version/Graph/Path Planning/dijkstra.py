from collections import defaultdict
import heapq

"""
graph = {0: {2: 1},
         1: {2: 8, 6:2, 5: 9},
         2: {1: 8, 6:7, 0:1},
         3: {},
         4: {7: 8},
         5: {1: 9, 7:4},
         6: {1: 2, 2:7},
         7: {5: 4,4:8}}
"""

def dijkstra(graph, initial, goal):
    inf = float('inf')
    dict = defaultdict(lambda:inf)
    previous = {}
    visited = set()

    dict[initial] = 0
    allNode = [ (dict[n], n) for n in graph.keys() ]
    heapq.heapify(allNode)

    while allNode:
        _, u = heapq.heappop(allNode)
        visited.add(u)

        if dict[u] == inf:
            # means no connections from initial to the rest of graph
            break

        if u == goal:
            break

        for v in graph[u]:
            if v in visited:
                continue
            alt = dict[u] + graph[u][v]
            if alt < dict[v]:

                idx = allNode.index((dict[v],v))
                allNode[idx] = (alt, v)
                heapq.heapify(allNode)

                dict[v] = alt
                previous[v] = u

    return previous, dict
