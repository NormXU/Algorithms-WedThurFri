"""
	BFS Template

	neighbor 表示从某个点 head 出发，可以走到的下一层的节点。
	set 存储已经访问过的节点（已经丢到 queue 里去过的节点）
	queue 存储等待被拓展到下一层的节点
	set 与 queue 是一对好基友，无时无刻都一起出现，往 queue 里新增一个节点，就要同时丢到 set 里。



	无需分层：即问题不需要我区分开不同层级的结果信息
	
"""
from collection import deque

queue = deque() # list-like container with fast appends and pops on either end
seen = set()

seen.add(start)
queue.append(start)

while len(queue):
	head = queue.popleft() # Pop out the first element in the queue
	for neighbor in head.neighbors: #以head为起点，其附近所有的neighbor都检查一遍
		if neighbor not in seen:
			seen.add(neighbor)
			queue.append(neighbor)






"""
	BFS Template

	neighbor 表示从某个点 head 出发，可以走到的下一层的节点。
	set 存储已经访问过的节点（已经丢到 queue 里去过的节点）
	queue 存储等待被拓展到下一层的节点
	set 与 queue 是一对好基友，无时无刻都一起出现，往 queue 里新增一个节点，就要同时丢到 set 里。



	需分层：即问题需要我区分开不同层级的结果信息
	
"""
from collection import queue

queue = deque()
seen = set()
while len(queue):
	size = len(queue)
	for _ in range(size): # 把同一层的所有元素都Pop出来
		head = queue.popleft()
		for neighbor in head.neighbors:
			seen.add(neighbor)
			queue.append(neighbor)