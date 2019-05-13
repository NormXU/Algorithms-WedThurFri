"""
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

	1. Only one letter can be changed at a time
	2. Each intermediate word must exist in the dictionary
Example
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
"""
class Solution:
    """
    @param: start: a string
    @param: end: a string
    @param: dict: a set of string
    @return: An integer
    """
    def ladderLength(self, start, end, dict):
    	from collections import deque
    	queue = deque([start])
    	visited = set([start])

    	dict.add(end)

    	distance = 0

    	while queue:
    		distance += 1
    		for _ in range(len(queue)):
    			word = queue.popleft()

    			if word == end:
    				return distance


    			for next_word in self.get_nextWord(word):
    				if next_word not in dict or next_word in visited:
    					continue
    				queue.append(next_word)
    				visited.add(next_word)

    def get_nextWord(self, word):
    	words = []
    	for i in range(len(word)):
    		left, right = word[:i], word[i+1:]
    		for char in "abcdefghijklmnopqrstuvwxyz":
    			if char = word[i]:
    				continue
    			words.append(left + char + right)

    	return words