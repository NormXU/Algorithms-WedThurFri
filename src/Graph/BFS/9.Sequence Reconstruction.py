"""
Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 10^4. Reconstruction means building a shortest common supersequence of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.

Example
Given org = [1,2,3], seqs = [[1,2],[1,3]]
Return false
Explanation:
[1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.

Given org = [1,2,3], seqs = [[1,2]]
Return false
Explanation:
The reconstructed sequence can only be [1,2].

Given org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
Return true
Explanation:
The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].

Given org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
Return true
"""
class Solution:
    """
    @param org: a permutation of the integers from 1 to n
    @param seqs: a list of sequences
    @return: true if it can be reconstructed only one or false
    """
    def sequenceReconstruction(self, org, seqs):
        # write your code here
        nodes = set([])
        
        for seq in seqs:
            nodes = nodes | set(seq)

        # Initialization
            
        degree = {x:0 for x in nodes}
        edges =  {x:[] for x in nodes} 
        
        for seq in seqs:
            for i in range(len(seq) - 1):
                degree[seq[i+1]] += 1
                edges[seq[i]].append(seq[i+1])
                
        from collections import deque
        q = deque([x for x in degree if degree[x] == 0])
        
        result = []
        
        while len(q) == 1:
            node = q.popleft()
            result.append(node)
            for neighbor in edges[node]:
                degree[neighbor] -= 1
                if degree[neighbor] == 0:
                    q.append(neighbor)
        
        return result == org