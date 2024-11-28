from typing import List

# Leetcode 734
class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        passed_nodes = {}
        passed_nodes.add(k)
        cur_stack = {}
        for i in range(len(times)):
            if times[i][0] ==

