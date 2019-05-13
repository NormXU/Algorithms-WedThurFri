"""
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Example
Example1

Input:
LRUCache(2)
set(2, 1)
set(1, 1)
          [(2,1), (1,1)]
get(2)
          [(1,1), (2,1)]
set(4, 1)
          [(2,1), (4,1)]
get(1)
            -1
get(2)
          [(4,1), (2,1)]
Output:
[1,-1,1]
"""
from collections import OrderedDict

class LRUCache:
    """
    @param: capacity: An integer
    """
    def __init__(self, capacity):
        # do intialization if necessary
        self.capacity = capacity
        self.cache = OrderedDict()

    """
    @param: key: An integer
    @return: An integer
    """
    def get(self, key):
        # write your code here
        if key not in self.cache:
            return -1

        # Pop the value and insert to the bottom of the queue
        value = self.cache.pop(key)
        self.cache[key] = value
        return value

    """
    @param: key: An integer
    @param: value: An integer
    @return: nothing
    """
    def set(self, key, value):
        # write your code here
        if key in self.cache:
            self.cache.pop(key)
        elif len(self.cache) == self.capacity:
            self.cache.popitem(last = False)

        self.cache[key] = value
