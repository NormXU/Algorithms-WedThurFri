"""
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example
Given n = 2, prerequisites = [[1,0]]
Return true

Given n = 2, prerequisites = [[1,0],[0,1]]
Return false
"""
class Solution:
    """
    @param: numCourses: a total of n courses
    @param: prerequisites: a list of prerequisite pairs
    @return: true if can finish all courses or false
    """
    def canFinish(self, numCourses, prerequisites):
    	G = [[] for _ in numCourses]
    	degree = [0] * numCourses

    	for i,j in prerequisites:
    		# 入度初始化
    		G[j].append(i)
    		degree[i] += 1

    	queue = []
    	for i in range(numCourses):
    		if degree[i] == 0:
    			queue.append(i)

    	for q in queue:
    		for j in G[q]:
    			degree[j] -= 1
    			if degree[j] == 0:
    				queue.append(j)

    	return len(queue) == numCourses